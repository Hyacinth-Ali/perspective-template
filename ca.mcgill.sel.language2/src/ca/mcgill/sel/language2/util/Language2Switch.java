/**
 */
package ca.mcgill.sel.language2.util;

import ca.mcgill.sel.language2.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ca.mcgill.sel.language2.Language2Package
 * @generated
 */
public class Language2Switch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Language2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language2Switch() {
		if (modelPackage == null) {
			modelPackage = Language2Package.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Language2Package.LANGUAGE2: {
				Language2 language2 = (Language2)theEObject;
				T result = caseLanguage2(language2);
				if (result == null) result = caseNamedElement(language2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMA2: {
				LEMA2 lema2 = (LEMA2)theEObject;
				T result = caseLEMA2(lema2);
				if (result == null) result = caseNamedElement(lema2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMB2: {
				LEMB2 lemb2 = (LEMB2)theEObject;
				T result = caseLEMB2(lemb2);
				if (result == null) result = caseNamedElement(lemb2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMC2: {
				LEMC2 lemc2 = (LEMC2)theEObject;
				T result = caseLEMC2(lemc2);
				if (result == null) result = caseNamedElement(lemc2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMD2: {
				LEMD2 lemd2 = (LEMD2)theEObject;
				T result = caseLEMD2(lemd2);
				if (result == null) result = caseNamedElement(lemd2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEME2: {
				LEME2 leme2 = (LEME2)theEObject;
				T result = caseLEME2(leme2);
				if (result == null) result = caseNamedElement(leme2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMF2: {
				LEMF2 lemf2 = (LEMF2)theEObject;
				T result = caseLEMF2(lemf2);
				if (result == null) result = caseNamedElement(lemf2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMG2: {
				LEMG2 lemg2 = (LEMG2)theEObject;
				T result = caseLEMG2(lemg2);
				if (result == null) result = caseNamedElement(lemg2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMH2: {
				LEMH2 lemh2 = (LEMH2)theEObject;
				T result = caseLEMH2(lemh2);
				if (result == null) result = caseNamedElement(lemh2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMI2: {
				LEMI2 lemi2 = (LEMI2)theEObject;
				T result = caseLEMI2(lemi2);
				if (result == null) result = caseNamedElement(lemi2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMJ2: {
				LEMJ2 lemj2 = (LEMJ2)theEObject;
				T result = caseLEMJ2(lemj2);
				if (result == null) result = caseNamedElement(lemj2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEMK2: {
				LEMK2 lemk2 = (LEMK2)theEObject;
				T result = caseLEMK2(lemk2);
				if (result == null) result = caseNamedElement(lemk2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.LEML2: {
				LEML2 leml2 = (LEML2)theEObject;
				T result = caseLEML2(leml2);
				if (result == null) result = caseNamedElement(leml2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language2Package.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguage2(Language2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMA2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMA2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMA2(LEMA2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMB2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMB2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMB2(LEMB2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMC2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMC2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMC2(LEMC2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMD2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMD2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMD2(LEMD2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEME2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEME2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEME2(LEME2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMF2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMF2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMF2(LEMF2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMG2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMG2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMG2(LEMG2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMH2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMH2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMH2(LEMH2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMI2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMI2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMI2(LEMI2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMJ2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMJ2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMJ2(LEMJ2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMK2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMK2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMK2(LEMK2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEML2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEML2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEML2(LEML2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Language2Switch
