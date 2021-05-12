package ca.mcgill.sel.perspective.test;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;

public class BModelFacadeAction {

	public static EObject createOtherElementsForB1(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA1();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA1(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB2(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA2();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA2(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB3(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA3();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA3(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB4(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA4();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA4(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB5(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA5();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA5(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB6(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA6();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA6(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB7(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA7();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA7(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB8(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA8();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA8(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB9(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA9();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA9(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB10(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA10();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA10(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB11(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA11();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA11(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForB12(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = AmodelPackage.eINSTANCE.getA12();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleAModelAction.createA12(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}

	public static void deleteModelElement(EObject otherElement) {
		if (otherElement instanceof A1) {
			AModelController.getInstance().removeA1((A1) otherElement);
		} else if (otherElement instanceof A2) {
			AModelController.getInstance().removeA2((A2) otherElement);
		} else if (otherElement instanceof A3) {
			AModelController.getInstance().removeA3((A3) otherElement);
		} else if (otherElement instanceof A4) {
			AModelController.getInstance().removeA4((A4) otherElement);
		} else if (otherElement instanceof A5) {
			AModelController.getInstance().removeA5((A5) otherElement);
		} else if (otherElement instanceof A6) {
			AModelController.getInstance().removeA6((A6) otherElement);
		} else if (otherElement instanceof A7) {
			AModelController.getInstance().removeA7((A7) otherElement);
		} else if (otherElement instanceof A8) {
			AModelController.getInstance().removeA8((A8) otherElement);
		} else if (otherElement instanceof A9) {
			AModelController.getInstance().removeA9((A9) otherElement);
		} else if (otherElement instanceof A10) {
			AModelController.getInstance().removeA10((A10) otherElement);
		} else if (otherElement instanceof A11) {
			AModelController.getInstance().removeA11((A11) otherElement);
		} else if (otherElement instanceof A12) {
			AModelController.getInstance().removeA12((A12) otherElement);
		} else if (otherElement instanceof B1) {
			BModelController.getInstance().removeB1((B1) otherElement);
		} else if (otherElement instanceof B2) {
			BModelController.getInstance().removeB2((B2) otherElement);
		} else if (otherElement instanceof B3) {
			BModelController.getInstance().removeB3((B3) otherElement);
		} else if (otherElement instanceof B4) {
			BModelController.getInstance().removeB4((B4) otherElement);
		} else if (otherElement instanceof B5) {
			BModelController.getInstance().removeB5((B5) otherElement);
		} else if (otherElement instanceof B6) {
			BModelController.getInstance().removeB6((B6) otherElement);
		} else if (otherElement instanceof B7) {
			BModelController.getInstance().removeB7((B7) otherElement);
		} else if (otherElement instanceof B8) {
			BModelController.getInstance().removeB8((B8) otherElement);
		} else if (otherElement instanceof B9) {
			BModelController.getInstance().removeB9((B9) otherElement);
		} else if (otherElement instanceof B10) {
			BModelController.getInstance().removeB10((B10) otherElement);
		} else if (otherElement instanceof B11) {
			BModelController.getInstance().removeB11((B11) otherElement);
		} else if (otherElement instanceof B12) {
			BModelController.getInstance().removeB12((B12) otherElement);
		} 
		
	}
}
