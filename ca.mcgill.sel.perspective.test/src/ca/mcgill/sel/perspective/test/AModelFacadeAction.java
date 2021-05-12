package ca.mcgill.sel.perspective.test;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.A1;
import ca.mcgill.sel.amodel.A10;
import ca.mcgill.sel.amodel.A11;
import ca.mcgill.sel.amodel.A12;
import ca.mcgill.sel.amodel.A2;
import ca.mcgill.sel.amodel.A3;
import ca.mcgill.sel.amodel.A4;
import ca.mcgill.sel.amodel.A5;
import ca.mcgill.sel.amodel.A6;
import ca.mcgill.sel.amodel.A7;
import ca.mcgill.sel.amodel.A8;
import ca.mcgill.sel.amodel.A9;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.bmodel.B1;
import ca.mcgill.sel.bmodel.B10;
import ca.mcgill.sel.bmodel.B11;
import ca.mcgill.sel.bmodel.B12;
import ca.mcgill.sel.bmodel.B2;
import ca.mcgill.sel.bmodel.B3;
import ca.mcgill.sel.bmodel.B4;
import ca.mcgill.sel.bmodel.B5;
import ca.mcgill.sel.bmodel.B6;
import ca.mcgill.sel.bmodel.B7;
import ca.mcgill.sel.bmodel.B8;
import ca.mcgill.sel.bmodel.B9;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;

public class AModelFacadeAction {
	
	public static EObject createOtherElementsForA1(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB1();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB1(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA2(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB2();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB2(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA3(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB3();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB3(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA4(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB4();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB4(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA5(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB5();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB5(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA6(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB6();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB6(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA7(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB7();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB7(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA8(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB8();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB8(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA9(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB9();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB9(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA10(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB10();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB10(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA11(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB11();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB11(perspective, scene, roleName, otherOwner, name);
		}
		return newElement;
	}
	
	public static EObject createOtherElementsForA12(COREPerspective perspective, EObject metaclass, String roleName, COREScene scene, EObject otherOwner,
			 String name) {

		EObject newElement = null;
		EObject otherMetaclass = BmodelPackage.eINSTANCE.getB12();
		
		if (metaclass.equals(otherMetaclass)) {
			newElement = HandleBModelAction.createB12(perspective, scene, roleName, otherOwner, name);
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
