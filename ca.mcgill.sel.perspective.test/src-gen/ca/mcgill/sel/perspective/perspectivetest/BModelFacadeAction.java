package ca.mcgill.sel.perspective.perspectivetest;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;

import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.bmodel.controller.*;

public class BModelFacadeAction {













	public static EObject createOtherElementsForB1(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA1())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA1(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB2(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA2())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA2(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB3(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA3())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA3(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB4(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA4())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA4(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB5(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA5())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA5(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB6(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA6())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA6(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB7(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA7())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA7(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB8(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA8())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA8(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB9(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA9())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA9(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB10(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA10())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA10(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB11(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA11())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA11(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForB12(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA12())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA12(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static void deleteModelElement(EObject otherElement) {
		if (otherElement instanceof A1) {
			AModelController.getInstance().removeA1((A1) otherElement);
		}
		else if (otherElement instanceof A2) {
			AModelController.getInstance().removeA2((A2) otherElement);
		}
		else if (otherElement instanceof A3) {
			AModelController.getInstance().removeA3((A3) otherElement);
		}
		else if (otherElement instanceof A4) {
			AModelController.getInstance().removeA4((A4) otherElement);
		}
		else if (otherElement instanceof A5) {
			AModelController.getInstance().removeA5((A5) otherElement);
		}
		else if (otherElement instanceof A6) {
			AModelController.getInstance().removeA6((A6) otherElement);
		}
		else if (otherElement instanceof A7) {
			AModelController.getInstance().removeA7((A7) otherElement);
		}
		else if (otherElement instanceof A8) {
			AModelController.getInstance().removeA8((A8) otherElement);
		}
		else if (otherElement instanceof A9) {
			AModelController.getInstance().removeA9((A9) otherElement);
		}
		else if (otherElement instanceof A10) {
			AModelController.getInstance().removeA10((A10) otherElement);
		}
		else if (otherElement instanceof A11) {
			AModelController.getInstance().removeA11((A11) otherElement);
		}
		else if (otherElement instanceof A12) {
			AModelController.getInstance().removeA12((A12) otherElement);
		}
		else if (otherElement instanceof B1) {
			BModelController.getInstance().removeB1((B1) otherElement);
		}
		else if (otherElement instanceof B2) {
			BModelController.getInstance().removeB2((B2) otherElement);
		}
		else if (otherElement instanceof B3) {
			BModelController.getInstance().removeB3((B3) otherElement);
		}
		else if (otherElement instanceof B4) {
			BModelController.getInstance().removeB4((B4) otherElement);
		}
		else if (otherElement instanceof B5) {
			BModelController.getInstance().removeB5((B5) otherElement);
		}
		else if (otherElement instanceof B6) {
			BModelController.getInstance().removeB6((B6) otherElement);
		}
		else if (otherElement instanceof B7) {
			BModelController.getInstance().removeB7((B7) otherElement);
		}
		else if (otherElement instanceof B8) {
			BModelController.getInstance().removeB8((B8) otherElement);
		}
		else if (otherElement instanceof B9) {
			BModelController.getInstance().removeB9((B9) otherElement);
		}
		else if (otherElement instanceof B10) {
			BModelController.getInstance().removeB10((B10) otherElement);
		}
		else if (otherElement instanceof B11) {
			BModelController.getInstance().removeB11((B11) otherElement);
		}
		else if (otherElement instanceof B12) {
			BModelController.getInstance().removeB12((B12) otherElement);
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


