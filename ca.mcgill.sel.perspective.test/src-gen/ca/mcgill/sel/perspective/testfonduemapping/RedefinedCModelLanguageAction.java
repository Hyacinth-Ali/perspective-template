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

import ca.mcgill.sel.cmodel.*;
import ca.mcgill.sel.cmodel.controller.*;
import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.bmodel.*;

public class RedefinedCModelLanguageAction {
	public static EObject createNewC1(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		EObject newElement = null;
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, CmodelPackage.eINSTANCE.getC1());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new element
		CModelController.getInstance().createC1((CModel) owner, name);
						
		// retrieve the new element
		newElement = ModelElementStatus.INSTANCE.getNewElement(owner, CmodelPackage.eINSTANCE.getC1());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
		
		if (!isFacadeCall) {
			createOtherElementsForC1(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
		

	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForC1(COREPerspective perspective, COREScene scene, String currentRoleName,
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
			createOtherElementsForC1(perspective, mappingType, scene, currentRoleName, currentElement, owner,
											 	name);
		}
			
		}
	}
	
	private static void createOtherElementsForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, String currentRoleName,
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
			canCreateOrUseNonMappedElementForC1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;
	
		// C2/C10
		case CREATE:
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForC1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;
	
		// C3/C11
		case CAN_CREATE_MANY:
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForC1(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;
	
		// C4/C12
		case CREATE_AT_LEAST_ONE:
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForC1(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;
			
		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForC1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;
	
		// C6
		case CREATE_OR_USE:
			createOrUseElementForC1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;
	
		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForC1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;
	
		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForC1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForC1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForC1(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForC1(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForC1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
		}
	}
	
	

	public static EObject createNewC2(COREPerspective perspective, COREScene scene, String currentRole, 
		boolean isFacadeCall, EObject owner, String name) {
		
		EObject newElement = null;
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		createSecondaryEffects.add(CmodelPackage.eINSTANCE.getC1());
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, CmodelPackage.eINSTANCE.getC2());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new element
		CModelController.getInstance().createC2((CModel) owner, name);
						
		// retrieve the new element
		newElement = ModelElementStatus.INSTANCE.getNewElement(owner, CmodelPackage.eINSTANCE.getC2());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> a = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		Map<EObject, Collection<EObject>> after = new HashMap<EObject, Collection<EObject>>(a);
		
		if (!isFacadeCall) {
			createOtherElementsForC2(perspective, scene, currentRole, newElement, owner,
			 	name);						
		}
		createNewC2CreateSecondaryEffects(perspective, scene, currentRole, after, owner, 
			name);
		

	//		try {
	//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
	//		} catch (PerspectiveException e) {
	//			RamApp.getActiveScene().displayPopup(e.getMessage());
	//		}
	
	return newElement;
	
	
	}
	
	public static void createOtherElementsForC2(COREPerspective perspective, COREScene scene, String currentRoleName,
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
			createOtherElementsForC2(perspective, mappingType, scene, currentRoleName, currentElement, owner,
											 	name);
		}
			
		}
	}
	
	private static void createOtherElementsForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, String currentRoleName,
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
			canCreateOrUseNonMappedElementForC2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;
	
		// C2/C10
		case CREATE:
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForC2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;
	
		// C3/C11
		case CAN_CREATE_MANY:
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForC2(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;
	
		// C4/C12
		case CREATE_AT_LEAST_ONE:
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForC2(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;
			
		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForC2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;
	
		// C6
		case CREATE_OR_USE:
			createOrUseElementForC2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;
	
		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForC2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;
	
		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForC2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
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
	private static void canCreateOrUseElementForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// save the recent changes
			// BasePerspectiveController.saveModel(scene);
			if(!otherExist) {
				createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);	
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
	private static void createOrUseElementForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
			String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
				owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseManyElementsForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseAtLeastOneElementForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedElementForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
				otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
											owner, name);
			}
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
			// BasePerspectiveController.saveModel(scene);
			if (!otherExist) {
				createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedElementForC2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
			EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {
	
		EObject otherElement = null;
		boolean otherExist = true;
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	
		// create other element if the corresponding element is null
		// or mapped.
		if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
			otherExist = false;
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// BasePerspectiveController.saveModel(scene);
		// stop the recursion if other element exists.
		if (!otherExist) {
			createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void canCreateOrUseNonMappedManyElementsForC2(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
	private static void createOrUseNonMappedAtLeastOneElementForC2(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
			otherElement = CModelLanguageFacadeAction.createOtherElementsForC2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
			COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		  	// BasePerspectiveController.saveModel(scene);
		  	createOtherElementsForC2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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

	public static void deleteC1(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		CModelController.getInstance().removeC1((C1) currentElement);
		deleteOtherElementsForC1(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForC1(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				CModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForC1(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					CModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForC1(perspective, scene, otherRoleName, otherElement);
				}
				break;
			}
		}
	}
	
	

	public static void deleteC2(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
		
		List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
							
		CModelController.getInstance().removeC2((C2) currentElement);
		deleteOtherElementsForC2(perspective, scene, currentRole, currentElement);
		
	}
	
	public static void deleteOtherElementsForC2(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
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
				CModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
				deleteOtherElementsForC2(perspective, scene, otherRoleName, otherElement);
				break;
	
			case DELETE_SINGLEMAPPED:
				List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
						otherElement);
				if (otherMappings.size() == 0) {
					CModelLanguageFacadeAction.deleteModelElement(perspective, scene, otherRoleName, otherElement);
					deleteOtherElementsForC2(perspective, scene, otherRoleName, otherElement);
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


