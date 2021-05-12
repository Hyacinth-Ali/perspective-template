package ca.mcgill.sel.perspective.test.samplecontroller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREModelElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.core.MappingEnd;
import ca.mcgill.sel.core.perspective.ActionType;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;
import ca.mcgill.sel.core.perspective.TemplateType;
import ca.mcgill.sel.ram.ui.perspective.QueryAction;
import ca.mcgill.sel.ram.ui.perspective.controller.BasePerspectiveController;
import ca.mcgill.sel.ram.ui.perspective.controller.PerspectiveException;

import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.bmodel.controller.*;
import ca.mcgill.sel.ram.ui.perspective.test.*;

public class RedefinedBModelAction {
 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


 	        


public static void createNewB4(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB4());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	BModelController.getInstance().createB4((BModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB4());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForB4(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForB4(COREPerspective perspective, COREScene scene, String currentRoleName,
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
			canCreateElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
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

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForB4(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForB4(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForB4(perspective, mappingType, scene, currentElement, currentRoleName,
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
private static void canCreateElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
private static void canCreateManyElementsForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createAtLeastOneElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void canCreateOrUseElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createOrUseElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void canCreateOrUseNonMappedElementForB4(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB4(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB4(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewB11(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB11());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	BModelController.getInstance().createB11((BModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB11());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForB11(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForB11(COREPerspective perspective, COREScene scene, String currentRoleName,
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
			canCreateElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
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

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForB11(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForB11(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForB11(perspective, mappingType, scene, currentElement, currentRoleName,
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
private static void canCreateElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
private static void canCreateManyElementsForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createAtLeastOneElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void canCreateOrUseElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createOrUseElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void canCreateOrUseNonMappedElementForB11(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB11(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB11(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void createNewB12(COREPerspective perspective, COREScene scene, String currentRole, 
	EObject owner, String name) {
	
	List<EObject> createSecondaryEffects = new ArrayList<EObject>();
	
	// record existing elements.
	BaseFacade.INSTANCE.setMainExistingElements(owner, BmodelPackage.eINSTANCE.getB12());
	BaseFacade.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
	
	// primary language action to create a new class
	BModelController.getInstance().createB12((BModel) owner, name);

	// retrieve the new element
	EObject newElement = BaseFacade.INSTANCE.getNewElement(owner, BmodelPackage.eINSTANCE.getB12());
	
	// get other new elements foe each language element
	Map<EObject, Collection<EObject>> after = BaseFacade.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);

	createOtherElementsForB12(perspective, scene, currentRole, newElement,
	 	owner, name);
	 	
	HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, currentRole, after, 
		owner, name);

//		try {
//			createOtherElementsForLEMA1(perspective, scene, newElement, currentRole, owner, name);
//		} catch (PerspectiveException e) {
//			RamApp.getActiveScene().displayPopup(e.getMessage());
//		}


}

public static void createOtherElementsForB12(COREPerspective perspective, COREScene scene, String currentRoleName,
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
			canCreateElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C2
		case CREATE:
			createElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
			break;

		// C3
		case CAN_CREATE_MANY:
			canCreateManyElementsForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE, 
					owner, name);
			break;

		// C4
		case CREATE_AT_LEAST_ONE:
			createAtLeastOneElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName, otherLE,
					owner, name);
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

		// C9
		case CAN_CREATE_OR_USE_NON_MAPPED:
			canCreateOrUseNonMappedElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C10
		case CREATE_OR_USE_NON_MAPPED:
			createOrUseNonMappedElementForB12(perspective, mappingType, scene, currentElement, currentRoleName, otherRoleName,
					otherLE, owner, name);
			break;

		// C11
		case CAN_CREATE_OR_USE_NON_MAPPED_MANY:
			canCreateOrUseNonMappedManyElementsForB12(perspective, mappingType, scene, currentElement, currentRoleName,
					otherRoleName, otherLE, owner, name);
			break;

		// C12
		case CREATE_OR_USE_NON_MAPPED_AT_LEAST_ONE:
			createOrUseNonMappedAtLeastOneElementForB12(perspective, mappingType, scene, currentElement, currentRoleName,
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
private static void canCreateElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	// Ask the user whether to create other model element and then establish
	// the MEM
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
			owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
		// save the recent changes
		// BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene, EObject currentElement,
		String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
								owner, name);
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(), name);
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
private static void canCreateManyElementsForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappings();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createAtLeastOneElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	int numberOfMappings = QueryAction.INSTANCE.askNumberOfMappingsAtLeastOne();
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void canCreateOrUseElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
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
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//			BasePerspectiveController.saveModel(scene);
		if (!otherExist) {
			createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void createOrUseElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean otherExist = true;
	// Check if a corresponding element exist, either mapped or not
	otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
	if (otherElement == null) {
		otherExist = false;
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
	}
	COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//		BasePerspectiveController.saveModel(scene);
	if (!otherExist) {
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
			numberOfMappings--;
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		// call recursive method since a new element was used in the mapping
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
private static void canCreateOrUseNonMappedElementForB12(COREPerspective perspective, CORELanguageElementMapping mappingType, COREScene scene,
		EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE, EObject owner, String name) {

	EObject otherElement = null;
	boolean isCreateMapping = QueryAction.INSTANCE.isCreateMapping();
	if (isCreateMapping) {
		otherElement = QueryAction.INSTANCE.findCorrespondingElement(scene, mappingType, currentElement.eClass(), currentElement, currentRoleName, otherRoleName);
		// creates new element if other element does not exist or it is
		// already mapped.
		if (otherElement == null
				|| COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene, otherElement).size() != 0) {
			otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
										owner, name);
		}
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//				BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//		BasePerspectiveController.saveModel(scene);
	// stop the recursion if other element exists.
	if (!otherExist) {
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//	  			BasePerspectiveController.saveModel(scene);
//				No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
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
//		  			BasePerspectiveController.saveModel(scene);
//					No need for recursive call since this is a mapping with an existing element.
				numberOfMappings--;
			}
		}
	}
	for (int count = 0; count < numberOfMappings; count++) {
		otherElement = BModelFacadeAction.createOtherElementsForB12(perspective, otherLE, otherRoleName, scene, 
									owner, name);
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, otherElement, false);
//	  		BasePerspectiveController.saveModel(scene);
		createOtherElementsForB12(perspective, scene, otherRoleName, otherElement, otherElement.eContainer(),
				name);
	}
}

 	        


public static void deleteB4(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	BModelController.getInstance().removeB4((B4) currentElement);
	deleteOtherElementsForB4(perspective, scene, currentRole, currentElement);
}

private static void deleteOtherElementsForB4(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
			BModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForB4(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				BModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForB4(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteB11(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	BModelController.getInstance().removeB11((B11) currentElement);
	deleteOtherElementsForB11(perspective, scene, currentRole, currentElement);
}

private static void deleteOtherElementsForB11(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
			BModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForB11(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				BModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForB11(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


public static void deleteB12(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {
	BModelController.getInstance().removeB12((B12) currentElement);
	deleteOtherElementsForB12(perspective, scene, currentRole, currentElement);
}

private static void deleteOtherElementsForB12(COREPerspective perspective, COREScene scene, String currentRole, EObject currentElement) {

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
			BModelFacadeAction.deleteModelElement(otherElement);
			deleteOtherElementsForB12(perspective, scene, otherRoleName, otherElement);
			break;

		case DELETE_SINGLEMAPPED:
			List<COREModelElementMapping> otherMappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					otherElement);
			if (otherMappings.size() == 0) {
				BModelFacadeAction.deleteModelElement(otherElement);
				deleteOtherElementsForB12(perspective, scene, otherRoleName, otherElement);
			}
			break;
		}
	}
}

 	        


}


