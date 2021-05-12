package ca.mcgill.sel.perspective.test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.perspective.perspectivetest.RedefinedAModelAction;
//import ca.mcgill.sel.ram.ui.perspective.test.samplecontroller.RedefinedAModelAction;

public class HandleSecondaryEffect {
	
	public static HandleSecondaryEffect INSTANCE = new HandleSecondaryEffect();
	
	private HandleSecondaryEffect() {
		
	}

	public void createSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole, Map<EObject, Collection<EObject>> after, EObject owner, String name) {
		for (Map.Entry<EObject, Collection<EObject>> e : after.entrySet()) {
			Collection<EObject> newElements = e.getValue();
			for (EObject newElement : newElements) {
				EObject b2Metaclass = AmodelPackage.eINSTANCE.getA2();
				EObject b3Metaclass = AmodelPackage.eINSTANCE.getA3();
				EObject b4Metaclass = AmodelPackage.eINSTANCE.getA4();
				if (newElement.eClass().equals(b2Metaclass)) {
					RedefinedAModelAction.createOtherElementsForA2(perspective, scene, currentRole, newElement,
							newElement.eContainer(), name);
				} else if (newElement.eClass().equals(b3Metaclass)) {
					RedefinedAModelAction.createOtherElementsForA3(perspective, scene, currentRole, newElement,
							newElement.eContainer(), name);
				} else if (newElement.eClass().equals(b4Metaclass)) {
					RedefinedAModelAction.createOtherElementsForA4(perspective, scene, currentRole, newElement,
							newElement.eContainer(), name);
				}
			}
		}
		
	}

	public void deleteSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole,
			List<EObject> deleteSecondaryEffects) {
		for (EObject deletedElement : deleteSecondaryEffects) {
			EObject b2Metaclass = AmodelPackage.eINSTANCE.getA2();
			EObject b3Metaclass = AmodelPackage.eINSTANCE.getA3();
			EObject b4Metaclass = AmodelPackage.eINSTANCE.getA4();
			if (deletedElement.eClass().equals(b2Metaclass)) {
				RedefinedAModelAction.deleteOtherElementsForA2(perspective, scene, currentRole, deletedElement);
			} else if (deletedElement.eClass().equals(b3Metaclass)) {
				RedefinedAModelAction.deleteOtherElementsForA3(perspective, scene, currentRole, deletedElement);
			} else if (deletedElement.eClass().equals(b4Metaclass)) {
				RedefinedAModelAction.deleteOtherElementsForA4(perspective, scene, currentRole, deletedElement);
			}
		}
		
	}

}
