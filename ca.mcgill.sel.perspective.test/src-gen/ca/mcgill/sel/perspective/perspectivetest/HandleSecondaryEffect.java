package ca.mcgill.sel.perspective.perspectivetest;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.bmodel.*;

public class HandleSecondaryEffect {
	
	public static HandleSecondaryEffect INSTANCE = new HandleSecondaryEffect();
		
	private HandleSecondaryEffect() {
			
	}
	
	public void createSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole, Map<EObject, Collection<EObject>> after, EObject owner, String name) {
		for (Map.Entry<EObject, Collection<EObject>> e : after.entrySet()) {
			Collection<EObject> newElements = e.getValue();
			for (EObject newElement : newElements) {
				if (newElement.eClass().equals(AmodelPackage.eINSTANCE.getA2())) {
								
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.createOtherElementsForA2(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
				}
				else if (newElement.eClass().equals(AmodelPackage.eINSTANCE.getA3())) {
						
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.createOtherElementsForA3(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
					}
				else if (newElement.eClass().equals(AmodelPackage.eINSTANCE.getA4())) {
						
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.createOtherElementsForA4(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
					}
				else if (newElement.eClass().equals(BmodelPackage.eINSTANCE.getB2())) {
						
					// Call the respective redefined recursive method
					RedefinedBModelLanguageAction.createOtherElementsForB2(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
					}
				else if (newElement.eClass().equals(BmodelPackage.eINSTANCE.getB3())) {
						
					// Call the respective redefined recursive method
					RedefinedBModelLanguageAction.createOtherElementsForB3(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
					}
				else if (newElement.eClass().equals(BmodelPackage.eINSTANCE.getB4())) {
						
					// Call the respective redefined recursive method
					RedefinedBModelLanguageAction.createOtherElementsForB4(perspective, scene, currentRole, newElement,
												newElement.eContainer(), name);
					}
			}
		}
	}
	public void deleteSecondaryEffects(COREPerspective perspective, COREScene scene, String currentRole,
				List<EObject> deleteSecondaryEffects) {
		for (EObject deletedElement : deleteSecondaryEffects) {
				if (deletedElement.eClass().equals(AmodelPackage.eINSTANCE.getA2())) {
								
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.deleteOtherElementsForA2(perspective, scene, currentRole, deletedElement);
				}
				else if (deletedElement.eClass().equals(AmodelPackage.eINSTANCE.getA3())) {
						
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.deleteOtherElementsForA3(perspective, scene, currentRole, deletedElement);
					}
				else if (deletedElement.eClass().equals(AmodelPackage.eINSTANCE.getA4())) {
						
					// Call the respective redefined recursive method
					RedefinedAModelLanguageAction.deleteOtherElementsForA4(perspective, scene, currentRole, deletedElement);
					}
			}
				
	}
	}
	
