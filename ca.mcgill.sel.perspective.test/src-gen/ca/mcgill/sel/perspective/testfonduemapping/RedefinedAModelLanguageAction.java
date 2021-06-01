package ca.mcgill.sel.perspective.testfonduemapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.*;
import ca.mcgill.sel.ram.ui.perspective.*;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.cmodel.*;

public class RedefinedAModelLanguageAction {
	public static EObject createNewA2(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA3());
		createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA4());
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA2());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		AModelController.getInstance().createA2((AModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA2());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForA2(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
		createNewA2CreateSecondaryEffects(perspective, scene, currentRole, after, owner, 
			name);
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForA2(COREPerspective perspective, COREScene scene, String currentRoleName,
			EObject currentElement, EObject owner, String name) throws PerspectiveException {
	
		List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
				currentElement.eClass(), currentRoleName);
		for (CORELanguageElementMapping mappingType : mappingTypes) {
			List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					currentElement);
	
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRoleName);
	
			// the metaclass of the element to be created.
			EObject otherLE = COREPerspectiveUtil.INSTANCE
					.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);
	
			ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);
	
			// check that the number of existing mappings is not zero.
			if (mappings.size() != 0) {
				continue;
			}
			switch (actionType) {
			
			// C1/C9
			case CAN_CREATE:
			case CAN_CREATE_OR_USE_NON_MAPPED:
				canCreateOrUseNonMappedElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForA2(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForA2(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
				
			default:
				// does nothing
	
			}
		}
	}
	
	/**
	 * (C1/C5): This method optionally creates a new element and then
	 * establishes model element mapping between the "element" parameter and the
	 * new element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		// Ask the user whether to create other model element and then establish
		// the MEM
		boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
		if (isCreateMapping) {
			otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
			if (otherElement == null) {
				otherExist = false;
				otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
			}
		}
	}

	/**
	 * (C2/C6): This method proactively creates a new element and then
	 * establishes model element mapping between the "element" parameter and the
	 * new element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
		
	}
	
	/**
	 * (C3/C7): This method can create or use an existing elements to
	 * establish model element mappings between the "element" parameter and each of the
	 * new element or existing elements. Similarly, the usser decides if the method should
	 * create the mappings.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseManyElementsForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				otherElement = existingElement;
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
				// BasePerspectiveController.saveModel(scene);
				numberOfMappings--;
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C4/C8): This method proactively creates or uses an existing element,
	 * at least one element, to establishes model element mapping between the 
	 * "element" parameter and the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseAtLeastOneElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				otherElement = existingElement;
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
				// BasePerspectiveController.saveModel(scene);
				numberOfMappings--;
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C9): This method can create or use non-mapped existing element to
	 * establishes model element mapping between the "element" parameter and the
	 * new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseNonMappedElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
		if (isCreateMapping) {
			otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
			// creates new element if other element does not exist or it is
			// already mapped.
			if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
				otherExist = false;
				otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
			}
			
	
		}
	}
	
	/**
	 * (C10): This method proactively creates or uses non-mapped existing element to
	 * establishes model element mapping between the "element" parameter and the
	 * new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseNonMappedElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C11): This method can create many elements or use non-mapped 
	 * existing elements to establish model element mappings between the "element" parameter 
	 * and each of the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseNonMappedManyElementsForA2(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName,
			EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// create mapping for each corresponding element which is not mapped
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				if (COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, existingElement).size() == 0) {
					otherElement = existingElement;
					COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  			// BasePerspectiveController.saveModel(scene);
					numberOfMappings--;
				}
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C12): This method proactively creates many elements or uses non-mapped 
	 * existing elements to establish model element mappings between the "element" parameter 
	 * and each of the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseNonMappedAtLeastOneElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName,
			EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create (at least one)
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// create mapping for each corresponding element which is not mapped
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				if (COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, existingElement).size() == 0) {
					otherElement = existingElement;
					COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			  		// BasePerspectiveController.saveModel(scene);
					numberOfMappings--;
				}
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	private static void createNewA2CreateSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole, Map<EObject, Collection<EObject>> after, 
			EObject owner, String name) {
		for (Map.Entry<EObject, Collection<EObject>> e : after.entrySet()) {
			Collection<EObject> newElements = e.getValue();
			for (EObject newElement : newElements) {
				if (newElement.eClass().equals(AmodelPackage.eINSTANCE.getA3())) {
								
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.createOtherElementsForA3(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
				}
				else if (newElement.eClass().equals(AmodelPackage.eINSTANCE.getA4())) {
						
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.createOtherElementsForA4(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
					}
			}
		}
	}

	public static EObject createNewA3(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA3());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		AModelController.getInstance().createA3((AModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA3());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForA3(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForA3(COREPerspective perspective, COREScene scene, String currentRoleName,
			EObject currentElement, EObject owner, String name) throws PerspectiveException {
	
		List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
				currentElement.eClass(), currentRoleName);
		for (CORELanguageElementMapping mappingType : mappingTypes) {
			List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					currentElement);
	
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRoleName);
	
			// the metaclass of the element to be created.
			EObject otherLE = COREPerspectiveUtil.INSTANCE
					.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);
	
			ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);
	
			// check that the number of existing mappings is not zero.
			if (mappings.size() != 0) {
				continue;
			}
			switch (actionType) {
			
			// C1/C9
			case CAN_CREATE:
			case CAN_CREATE_OR_USE_NON_MAPPED:
				canCreateOrUseNonMappedElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForA3(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForA3(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
				
			default:
				// does nothing
	
			}
		}
	}
	
	/**
	 * (C1/C5): This method optionally creates a new element and then
	 * establishes model element mapping between the "element" parameter and the
	 * new element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		// Ask the user whether to create other model element and then establish
		// the MEM
		boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
		if (isCreateMapping) {
			otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
			if (otherElement == null) {
				otherExist = false;
				otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
			}
		}
	}

	/**
	 * (C2/C6): This method proactively creates a new element and then
	 * establishes model element mapping between the "element" parameter and the
	 * new element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
		
	}
	
	/**
	 * (C3/C7): This method can create or use an existing elements to
	 * establish model element mappings between the "element" parameter and each of the
	 * new element or existing elements. Similarly, the usser decides if the method should
	 * create the mappings.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseManyElementsForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				otherElement = existingElement;
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
				// BasePerspectiveController.saveModel(scene);
				numberOfMappings--;
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C4/C8): This method proactively creates or uses an existing element,
	 * at least one element, to establishes model element mapping between the 
	 * "element" parameter and the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseAtLeastOneElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				otherElement = existingElement;
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
				// BasePerspectiveController.saveModel(scene);
				numberOfMappings--;
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C9): This method can create or use non-mapped existing element to
	 * establishes model element mapping between the "element" parameter and the
	 * new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseNonMappedElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
		if (isCreateMapping) {
			otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
			// creates new element if other element does not exist or it is
			// already mapped.
			if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
				otherExist = false;
				otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
			}
			
	
		}
	}
	
	/**
	 * (C10): This method proactively creates or uses non-mapped existing element to
	 * establishes model element mapping between the "element" parameter and the
	 * new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseNonMappedElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C11): This method can create many elements or use non-mapped 
	 * existing elements to establish model element mappings between the "element" parameter 
	 * and each of the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseNonMappedManyElementsForA3(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName,
			EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// create mapping for each corresponding element which is not mapped
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				if (COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, existingElement).size() == 0) {
					otherElement = existingElement;
					COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  			// BasePerspectiveController.saveModel(scene);
					numberOfMappings--;
				}
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C12): This method proactively creates many elements or uses non-mapped 
	 * existing elements to establish model element mappings between the "element" parameter 
	 * and each of the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseNonMappedAtLeastOneElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName,
			EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create (at least one)
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// create mapping for each corresponding element which is not mapped
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				if (COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, existingElement).size() == 0) {
					otherElement = existingElement;
					COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			  		// BasePerspectiveController.saveModel(scene);
					numberOfMappings--;
				}
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	

	public static EObject createNewA4(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA4());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		AModelController.getInstance().createA4((AModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA4());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForA4(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForA4(COREPerspective perspective, COREScene scene, String currentRoleName,
			EObject currentElement, EObject owner, String name) throws PerspectiveException {
	
		List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
				currentElement.eClass(), currentRoleName);
		for (CORELanguageElementMapping mappingType : mappingTypes) {
			List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					currentElement);
	
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRoleName);
	
			// the metaclass of the element to be created.
			EObject otherLE = COREPerspectiveUtil.INSTANCE
					.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);
	
			ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);
	
			// check that the number of existing mappings is not zero.
			if (mappings.size() != 0) {
				continue;
			}
			switch (actionType) {
			
			// C1/C9
			case CAN_CREATE:
			case CAN_CREATE_OR_USE_NON_MAPPED:
				canCreateOrUseNonMappedElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForA4(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForA4(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
				
			default:
				// does nothing
	
			}
		}
	}
	
	/**
	 * (C1/C5): This method optionally creates a new element and then
	 * establishes model element mapping between the "element" parameter and the
	 * new element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		// Ask the user whether to create other model element and then establish
		// the MEM
		boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
		if (isCreateMapping) {
			otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
			if (otherElement == null) {
				otherExist = false;
				otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
			}
		}
	}

	/**
	 * (C2/C6): This method proactively creates a new element and then
	 * establishes model element mapping between the "element" parameter and the
	 * new element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
		
	}
	
	/**
	 * (C3/C7): This method can create or use an existing elements to
	 * establish model element mappings between the "element" parameter and each of the
	 * new element or existing elements. Similarly, the usser decides if the method should
	 * create the mappings.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseManyElementsForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				otherElement = existingElement;
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
				// BasePerspectiveController.saveModel(scene);
				numberOfMappings--;
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C4/C8): This method proactively creates or uses an existing element,
	 * at least one element, to establishes model element mapping between the 
	 * "element" parameter and the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseAtLeastOneElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				otherElement = existingElement;
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
				// BasePerspectiveController.saveModel(scene);
				numberOfMappings--;
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C9): This method can create or use non-mapped existing element to
	 * establishes model element mapping between the "element" parameter and the
	 * new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseNonMappedElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
		if (isCreateMapping) {
			otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
			// creates new element if other element does not exist or it is
			// already mapped.
			if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
				otherExist = false;
				otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
			}
			
	
		}
	}
	
	/**
	 * (C10): This method proactively creates or uses non-mapped existing element to
	 * establishes model element mapping between the "element" parameter and the
	 * new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseNonMappedElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C11): This method can create many elements or use non-mapped 
	 * existing elements to establish model element mappings between the "element" parameter 
	 * and each of the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void canCreateOrUseNonMappedManyElementsForA4(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName,
			EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// create mapping for each corresponding element which is not mapped
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				if (COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, existingElement).size() == 0) {
					otherElement = existingElement;
					COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  			// BasePerspectiveController.saveModel(scene);
					numberOfMappings--;
				}
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	/**
	 * (C12): This method proactively creates many elements or uses non-mapped 
	 * existing elements to establish model element mappings between the "element" parameter 
	 * and each of the new element or the existing element.
	 * 
	 * @author Hyacinth Ali
	 * 
	 * @param perspective
	 * @param mappingType
	 * @param scene
	 * @param currentElement
	 * @param currentRoleName 
	 * @param otherRoleName
	 * @param otherLE
	 * @param currentOwner
	 * @param name
	 */
	private static void createOrUseNonMappedAtLeastOneElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName,
			EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		// Ask user how many mappings to create (at least one)
		int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
		List<EObject> otherElements = QueryAction.INSTANCE.findCorrespondingElements(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// create mapping for each corresponding element which is not mapped
		for (EObject existingElement : otherElements) {
			if (numberOfMappings <= 0) {
				break;
			} else {
				if (COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, existingElement).size() == 0) {
					otherElement = existingElement;
					COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			  		// BasePerspectiveController.saveModel(scene);
					numberOfMappings--;
				}
			}
		}
		for (int count = 0; count < numberOfMappings; count++) {
			otherElement = AModelLanguageFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	

	public static void deleteA2(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
		deleteSecondaryEffects.add(AModelController.getInstance().getA3());
		deleteSecondaryEffects.add(AModelController.getInstance().getA4());
							
		AModelController.getInstance().removeA2((A2) currentElement);
		deleteOtherElementsForA2(perspective, scene, currentRole, currentElement);
		
		deleteA2DeleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
	
	public static void deleteOtherElementsForA2(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(scene, currentElement);
		// Traditional for loop is used here to avoid
		// ConcurrentModificationException
		for (int i = 0; i < mappings.size(); i++) {
			COREModelElementMapping mapping = mappings.get(i);
			EObject otherElement = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentElement);
			CORELanguageElementMapping mappingType = COREPerspectiveUtil.INSTANCE.getMappingType(perspective, mapping);
			
			// get the delete action type
			ActionType deleteType = null;
			for (MappingEnd mappingEnd : mappingType.getMappingEnds()) {
				if (mappingEnd.getRoleName().equals(currentRole)) {
					deleteType = TemplateType.INSTANCE.getDeleteType(mappingEnd);
					break;
				}
			}
	
			// remove the mapping
			BasePerspectiveController.removeMapping(mapping);
			
			if (deleteType == null) {
				return;
			}
	
			// get other role name
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRole);
			switch (deleteType) {
	
			case DELETE_OTHERS:
				AModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForA2(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					AModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForA2(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
	private static void deleteA2DeleteSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole,
				List<EObject> deleteSecondaryEffects) {
		for (EObject deletedElement : deleteSecondaryEffects) {
				if (deletedElement.eClass().equals(AmodelPackage.eINSTANCE.getA3())) {
								
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.deleteOtherElementsForA3(perspective, scene, currentRole, deletedElement);
				}
				else if (deletedElement.eClass().equals(AmodelPackage.eINSTANCE.getA4())) {
						
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.deleteOtherElementsForA4(perspective, scene, currentRole, deletedElement);
					}
				else if (deletedElement.eClass().equals(CmodelPackage.eINSTANCE.getC1())) {
						
					// Call the respective redefined recursive method
					RedefinedCModelLanguageAction.deleteOtherElementsForC1(perspective, scene, currentRole, deletedElement);
					}
			}
				
	}

	public static void deleteA3(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		AModelController.getInstance().removeA3((A3) currentElement);
		deleteOtherElementsForA3(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForA3(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(scene, currentElement);
		// Traditional for loop is used here to avoid
		// ConcurrentModificationException
		for (int i = 0; i < mappings.size(); i++) {
			COREModelElementMapping mapping = mappings.get(i);
			EObject otherElement = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentElement);
			CORELanguageElementMapping mappingType = COREPerspectiveUtil.INSTANCE.getMappingType(perspective, mapping);
			
			// get the delete action type
			ActionType deleteType = null;
			for (MappingEnd mappingEnd : mappingType.getMappingEnds()) {
				if (mappingEnd.getRoleName().equals(currentRole)) {
					deleteType = TemplateType.INSTANCE.getDeleteType(mappingEnd);
					break;
				}
			}
	
			// remove the mapping
			BasePerspectiveController.removeMapping(mapping);
			
			if (deleteType == null) {
				return;
			}
	
			// get other role name
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRole);
			switch (deleteType) {
	
			case DELETE_OTHERS:
				AModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForA3(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					AModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForA3(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	

	public static void deleteA4(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		AModelController.getInstance().removeA4((A4) currentElement);
		deleteOtherElementsForA4(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForA4(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(scene, currentElement);
		// Traditional for loop is used here to avoid
		// ConcurrentModificationException
		for (int i = 0; i < mappings.size(); i++) {
			COREModelElementMapping mapping = mappings.get(i);
			EObject otherElement = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentElement);
			CORELanguageElementMapping mappingType = COREPerspectiveUtil.INSTANCE.getMappingType(perspective, mapping);
			
			// get the delete action type
			ActionType deleteType = null;
			for (MappingEnd mappingEnd : mappingType.getMappingEnds()) {
				if (mappingEnd.getRoleName().equals(currentRole)) {
					deleteType = TemplateType.INSTANCE.getDeleteType(mappingEnd);
					break;
				}
			}
	
			// remove the mapping
			BasePerspectiveController.removeMapping(mapping);
			
			if (deleteType == null) {
				return;
			}
	
			// get other role name
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRole);
			switch (deleteType) {
	
			case DELETE_OTHERS:
				AModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForA4(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					AModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForA4(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	






	private static void createNewC2CreateSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole, Map<EObject, Collection<EObject>> after, 
			EObject owner, String name) {
		for (Map.Entry<EObject, Collection<EObject>> e : after.entrySet()) {
			Collection<EObject> newElements = e.getValue();
			for (EObject newElement : newElements) {
				if (newElement.eClass().equals(CmodelPackage.eINSTANCE.getC1())) {
								
					// Call the respective redefined recursive method
					RedefinedCModelLanguageAction.createOtherElementsForC1(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
				}
			}
		}
	}



}


