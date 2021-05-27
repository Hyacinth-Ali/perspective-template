package ca.mcgill.sel.perspective.perspectivetest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.*;
import ca.mcgill.sel.ram.ui.perspective.*;

import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.bmodel.controller.*;

public class RedefinedBModelAction {
	public static EObject createNewB1(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB1());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB1((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB1());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB1(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB1(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB1(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB1(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB1(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB1(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB2(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB2());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB2((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB2());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB2(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB2(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB2(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB2(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB2(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB2(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB3(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB3());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB3((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB3());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB3(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB3(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB3(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB3(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB3(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB3(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB4(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB4());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB4((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB4());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB4(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB4(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB4(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB4(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB4(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB5(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB5());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB5((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB5());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB5(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB5(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB5(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB5(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB5(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB5(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB6(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB6());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB6((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB6());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB6(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB6(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB6(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB6(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB6(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB6(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB7(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB7());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB7((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB7());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB7(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB7(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB7(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB7(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB7(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB7(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB8(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB8());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB8((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB8());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB8(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB8(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB8(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB8(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB8(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB8(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB9(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB9());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB9((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB9());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB9(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB9(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB9(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB9(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB9(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB9(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB10(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB10());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB10((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB10());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB10(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB10(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB10(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB10(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB10(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB10(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB11(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB11());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB11((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB11());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB11(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB11(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB11(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB11(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB11(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static EObject createNewB12(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB12());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		BModelController.getInstance().createB12((BModel) owner, name);
	
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB12());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
	
		if (!isFacadeCall) {
			createOtherElementsForB12(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
	
	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForB12(COREPerspective perspective, COREScene scene, String currentRoleName,
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
				canCreateOrUseNonMappedElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C2/C10
			case CREATE:
			case CREATE_OR_USE_NON_MAPPED:
				createOrUseNonMappedElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
						otherLE, owner, name);
				break;
	
			// C3/C11
			case CAN_CREATE_MANY:
			case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
				canCreateOrUseNonMappedManyElementsForB12(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
	
			// C4/C12
			case CREATE_AT_LEAST_ONE:
			case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
				createOrUseNonMappedAtLeastOneElementForB12(perspective, mappingType, scene, currentElement, currentRoleName,
						otherRoleName, otherLE, owner, name);
				break;
			
			// C5
			case CAN_CREATE_OR_USE:
				canCreateOrUseElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C6
			case CREATE_OR_USE:
				createOrUseElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
						owner, name);
				break;
	
			// C7
			case CAN_CREATE_OR_USE_MANY:
				canCreateOrUseManyElementsForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
						owner, name);
				break;
	
			// C8
			case CREATE_OR_USE_AT_LEAST_ONE:
				createOrUseAtLeastOneElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForB12(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	public static void deleteB4(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		BModelController.getInstance().removeB4((B4) currentElement);
		deleteOtherElementsForB4(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForB4(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				BModelFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForB4(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					BModelFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForB4(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
	public static void deleteB11(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		BModelController.getInstance().removeB11((B11) currentElement);
		deleteOtherElementsForB11(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForB11(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				BModelFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForB11(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					BModelFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForB11(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
	public static void deleteB12(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		BModelController.getInstance().removeB12((B12) currentElement);
		deleteOtherElementsForB12(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForB12(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				BModelFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForB12(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					BModelFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForB12(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
}


