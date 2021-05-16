package ca.mcgill.sel.perspective.test;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.cmodel.*;
import ca.mcgill.sel.cmodel.controller.CModelController;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;

public class CModelFacadeAction {
	
	public static EObject createOtherElementsForC1(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject bMetaclass = BmodelPackage.eINSTANCE.getB1();
		
		if (metaclass.equals(bMetaclass)) {
			newElement = HandleBModelAction.createB1(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForC2(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject aMetaclass = AmodelPackage.eINSTANCE.getA2();
		
		if (metaclass.equals(aMetaclass)) {
			newElement = HandleAModelAction.createA2(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForC3(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject aMetaclass = AmodelPackage.eINSTANCE.getA3();
		
		if (metaclass.equals(aMetaclass)) {
			newElement = HandleAModelAction.createA3(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForC4(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject aMetaclass = AmodelPackage.eINSTANCE.getA4();
		
		if (metaclass.equals(aMetaclass)) {
			newElement = HandleAModelAction.createA4(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	
	public static void deleteModelElement(EObject otherElement) {
		if (otherElement instanceof C1) {
			CModelController.getInstance().removeC1((C1) otherElement);
		} else if (otherElement instanceof C2) {
			CModelController.getInstance().removeC2((C2) otherElement);
		} else if (otherElement instanceof C3) {
			CModelController.getInstance().removeC3((C3) otherElement);
		} else if (otherElement instanceof C4) {
			CModelController.getInstance().removeC4((C4) otherElement);
		} 
	}

}
