package ca.mcgill.sel.perspective.test;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.A1;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.bmodel.B1;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;

public class TestFacadeAction {
	
	/**
	 * Facade action which creates other model elements
	 * which need to be mapped with a new A1 element.
	 * @param perspective
	 * @param scene
	 * @param otherMetaclass
	 * @param otherRoleName
	 * @param currentOwner - the container of the A1 element
	 * @param name
	 * @return
	 */
	public static EObject createOtherElementsForA1(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB1();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB1(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA2(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB2();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB2(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	public static EObject createOtherElementsForA3(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB3();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB3(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA4(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB4();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB4(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA5(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB5();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB5(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA6(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB6();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB6(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA7(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB7();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB7(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA8(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB8();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB8(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA9(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB9();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB9(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA10(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB10();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB10(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA11(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB11();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB11(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA12(COREPerspective perspective, COREScene scene, EObject otherMetaclass,
			String otherRoleName, EObject currentOwner, String name) {

		EObject newElement = null;
		EObject metaclass = BmodelPackage.eINSTANCE.getB12();
		if (otherMetaclass.equals(metaclass)) {
			newElement = HandleBModelAction.createB12(perspective, scene, otherRoleName, currentOwner, name);
		}
		return newElement;
	}
	

	public static void deleteModelElement(EObject otherElement) {
		if (otherElement instanceof A1) {
			AModelController.getInstance().removeA1((A1) otherElement);
		} else if (otherElement instanceof B1) {
			BModelController.getInstance().removeB1((B1) otherElement);
		} 
		
	}

}
