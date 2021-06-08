package ca.mcgill.sel.perspective.testfonduemapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.*;
import ca.mcgill.sel.ram.ui.perspective.*;

import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.bmodel.controller.*;
import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.cmodel.*;

public class RedefinedBModelLanguageAction {
	public static EObject createNewB1(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		EObject newElement = null;
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB1());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new element
		BModelController.getInstance().createB1((BModel) owner, name);
						
		// retrieve the new element
		newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB1());
		
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
		
		if (COREPerspectiveUtil.INSTANCE.mappingsContainsElement(mappings, currentElement)) {
			continue;
		}
		
		MappingEnd currentMappingEnd = COREPerspectiveUtil.INSTANCE.getMappingEnd(mappingType, currentElement.eClass(), currentRoleName);
		MappingEnd otherMappingEnd = COREPerspectiveUtil.INSTANCE.getOtherMappingEnds(currentMappingEnd).get(0);
	
		if (otherMappingEnd.isRootMappingEnd()) {
			CreateModel.createOtherRootModels(perspective, mappingType, scene, currentRoleName, currentElement, name);
		} else {
			createOtherElementsForB1(perspective, mappingType, scene, currentRoleName, currentElement, owner,
											 	name);
		}
			
		}
	}
	
	public static void createOtherElementsForB1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, String currentRoleName,
				EObject currentElement, EObject owner, String name) {
			
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRoleName);
	
		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);
	
		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

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
				otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, owner, name);
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
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
				otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	

	public static EObject createNewB3(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		EObject newElement = null;
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB3());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new element
		BModelController.getInstance().createB3((BModel) owner, name);
						
		// retrieve the new element
		newElement = ModelElementStatus.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB3());
		
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
		
		if (COREPerspectiveUtil.INSTANCE.mappingsContainsElement(mappings, currentElement)) {
			continue;
		}
		
		MappingEnd currentMappingEnd = COREPerspectiveUtil.INSTANCE.getMappingEnd(mappingType, currentElement.eClass(), currentRoleName);
		MappingEnd otherMappingEnd = COREPerspectiveUtil.INSTANCE.getOtherMappingEnds(currentMappingEnd).get(0);
	
		if (otherMappingEnd.isRootMappingEnd()) {
			CreateModel.createOtherRootModels(perspective, mappingType, scene, currentRoleName, currentElement, name);
		} else {
			createOtherElementsForB3(perspective, mappingType, scene, currentRoleName, currentElement, owner,
											 	name);
		}
			
		}
	}
	
	public static void createOtherElementsForB3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, String currentRoleName,
				EObject currentElement, EObject owner, String name) {
			
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRoleName);
	
		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);
	
		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

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
				otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, owner, name);
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
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
				otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
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
			otherElement = BModelLanguageFacadeAction.createOtherElementsForB3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForB3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	

	public static void deleteB1(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		BModelController.getInstance().removeB1((B1) currentElement);
		deleteOtherElementsForB1(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForB1(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				BModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForB1(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					BModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForB1(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
	

	public static void deleteB3(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		BModelController.getInstance().removeB3((B3) currentElement);
		deleteOtherElementsForB3(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForB3(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				BModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForB3(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					BModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForB3(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
	

	/**
	 * This is a helper method which retrieves the corresponding container of an
	 * element to create.
	 * @param perspective
	 * @param scene -  the scene of the models
	 * @param currentOwner
	 * @param otherRole
	 * @return the container of the element to create.
	 */
	private static EObject getOwner(COREPerspective perspective, COREScene scene, EObject currentOwner, String otherRole) {
		EObject ownerOther = null;
	
		List<COREModelElementMapping> ownerMappings = COREPerspectiveUtil.INSTANCE.getMappings(currentOwner, scene);
		outerloop: for (COREModelElementMapping mapping : ownerMappings) {
			ownerOther = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentOwner);
			CORELanguageElementMapping mappingType = COREPerspectiveUtil.INSTANCE.getMappingType(perspective, mapping);
			for (MappingEnd mappingEnd : mappingType.getMappingEnds()) {
				if (mappingEnd.getRoleName().equals(otherRole)) {
					ownerOther = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentOwner);
					break outerloop;
				}
			}
		}
	
		return ownerOther;
	}
}


