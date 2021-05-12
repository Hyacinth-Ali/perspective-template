package ca.mcgill.sel.perspective.perspectivetest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.*;
import ca.mcgill.sel.ram.ui.perspective.*;
//import ca.mcgill.sel.ram.ui.perspective.controller.*;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.ram.ui.perspective.test.*;

public class RedefinedAModelAction {
public static void createNewA1(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA2());
	createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA3());
	createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA4());
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA1());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA1((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA1());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA1(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA1(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA1(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA1(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA1(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA1(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA1(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA1(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA1(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA2(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA2());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA2((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA2());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA2(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA2(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
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

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA2(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA2(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA2(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA2(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA2(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA2(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA3(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA3());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA3((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA3());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA3(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA3(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
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

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA3(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA3(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA3(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA3(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA3(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA3(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA4(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA4());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA4((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA4());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA4(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA4(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
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

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA4(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA4(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA5(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA5());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA5((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA5());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA5(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA5(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA5(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA5(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA5(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA5(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA5(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA5(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA5(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA6(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA6());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA6((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA6());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA6(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA6(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA6(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA6(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA6(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA6(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA6(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA6(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA6(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA7(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA7());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA7((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA7());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA7(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA7(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA7(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA7(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA7(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA7(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA7(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA7(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA7(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA8(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA8());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA8((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA8());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA8(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA8(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA8(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA8(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA8(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA8(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA8(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA8(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA8(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA9(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA9());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA9((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA9());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA9(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA9(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA9(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA9(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA9(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA9(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA9(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA9(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA9(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA10(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA10());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA10((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA10());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA10(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA10(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA10(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA10(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA10(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA10(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA10(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA10(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA10(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA11(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA11());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA11((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA11());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA11(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA11(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA11(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA11(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA11(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA11(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewA12(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, AmodelPackage.eINSTANCE.getA12());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	AModelController.getInstance().createA12((AModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA12());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForA12(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForA12(COREPerspective perspective, COREScene scene, String currentRoleName,
		EObject currentElement, EObject owner, String name) throws PerspectiveException {

	List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
			currentElement.eClass(), currentRoleName);
	for (CORELanguageElementMapping mappingType : mappingTypes) {
		List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
				currentElement);

		// other role names, i.e., excluding the current role
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRoleName);

		// the metaclass of the element to be created.
		EObject otherLE = COREPerspectiveUtil.INSTANCE
				.getOtherLanguageElements(mappingType, currentElement.eClass(), currentRoleName).get(0);

		ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

		// check that the number of existing mappings is not zero.
		if (mappings.size() != 0) {
			break;
		}
		switch (actionType) {

		// C1
		case CAN_CREATE:
			canCreateElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C5
		case CAN_CREATE_OR_USE:
			canCreateOrUseElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C6
		case CREATE_OR_USE:
			createOrUseElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C7
		case CAN_CREATE_OR_USE_MANY:
			canCreateOrUseManyElementsForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C8
		case CREATE_OR_USE_AT_LEAST_ONE:
			createOrUseAtLeastOneElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForA12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForA12(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForA12(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		}
	}
}

/**
 * CAN_CREATE (C1): This method optionally creates a new element and then
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
private static void canCreateElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}


/**
 * CAN_CREATE (C2): This method proactively creates a new element and then
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
private static void createElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
}

/**
 * CAN_CREATE (C3): This method can create many elements and then
 * establishes model element mapping between the "element" parameter and each of
 * the new elements. The user determines the number of new elements that can be created.
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
private static void canCreateManyElementsForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C4): This method proactively creates at least one element and then
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
private static void createAtLeastOneElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C5): This method can create or use an existing element to
 * establishes model element mapping between the "element" parameter and the
 * new element or the existing element. The user determines whether the method
 * should establish the model element mapping.
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
private static void canCreateOrUseElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Ask user whether to create a mapping
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		// Check if a corresponding element exist, either mapped or not
//			otherElement = QueryAction.INSTANCE.findCorrespondingElementByName(scene, otherElement, toCreateRoleName);
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		if (otherElement == null) {
			otherExist = false;
			otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
					name);
		}
	}
}

/**
 * CAN_CREATE (C6): This method proactively creates or uses an existing element to
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
private static void createOrUseElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C7): This method can create or use an existing elements to
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
private static void canCreateOrUseManyElementsForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C8): This method proactively creates or uses an existing element,
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
private static void createOrUseAtLeastOneElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C9): This method can create or use non-mapped existing element to
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
private static void canCreateOrUseNonMappedElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);

	}
}

/**
 * CAN_CREATE (C10): This method proactively creates or uses non-mapped existing element to
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
private static void createOrUseNonMappedElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);

	// create other element if the corresponding element is null
	// or mapped.
	if (otherElement == null || COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() > 0) {
		otherExist = false;
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);

	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C11): This method can create many elements or use non-mapped 
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
private static void canCreateOrUseNonMappedManyElementsForA12(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

/**
 * CAN_CREATE (C12): This method proactively creates many elements or uses non-mapped 
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
private static void createOrUseNonMappedAtLeastOneElementForA12(COREPerspective perspective, CORELanguageElementMapping mappingType,
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = AModelFacadeAction.createOtherElementsForA12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForA12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void deleteA1(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
	deleteSecondaryEffects.add(AModelController.getInstance().getA4());
						
	AModelController.getInstance().removeA1((A1) currentElement);
	deleteOtherElementsForA1(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA1(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA1(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA1(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA2(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA2((A2) currentElement);
	deleteOtherElementsForA2(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA2(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA2(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA3(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA3((A3) currentElement);
	deleteOtherElementsForA3(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA3(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
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
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA4(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA4(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA5(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA5((A5) currentElement);
	deleteOtherElementsForA5(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA5(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA5(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA5(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA6(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA6((A6) currentElement);
	deleteOtherElementsForA6(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA6(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA6(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA6(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA7(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA7((A7) currentElement);
	deleteOtherElementsForA7(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA7(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA7(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA7(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA8(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA8((A8) currentElement);
	deleteOtherElementsForA8(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA8(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA8(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA8(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA9(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA9((A9) currentElement);
	deleteOtherElementsForA9(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA9(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA9(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA9(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA10(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA10((A10) currentElement);
	deleteOtherElementsForA10(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA10(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA10(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA10(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA11(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA11((A11) currentElement);
	deleteOtherElementsForA11(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA11(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA11(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA11(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteA12(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	
	List<EObject> deleteSecondaryEffects = new ArrayList<EObject>();
						
	AModelController.getInstance().removeA12((A12) currentElement);
	deleteOtherElementsForA12(perspective, scene, currentRole, currentElement);
	
	if (deleteSecondaryEffects != null) {
		HandleSecondaryEffect.INSTANCE.deleteSecondaryEffects(perspective, scene, currentRole, deleteSecondaryEffects);
	}
}

public static void deleteOtherElementsForA12(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
		String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(perspective, currentRole);
		switch (deleteType) {

		case DELETE_OTHERS:
			AModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForA12(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				AModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForA12(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


 	        


 	        


 	        


 	        


 	        


 	        


}


