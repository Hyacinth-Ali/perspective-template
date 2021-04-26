/**
 */
package language1.util;

import language1.*;

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
 * @see language1.Language1Package
 * @generated
 */
public class Language1Switch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Language1Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language1Switch() {
		if (modelPackage == null) {
			modelPackage = Language1Package.eINSTANCE;
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
			case Language1Package.LANGUAGE1: {
				Language1 language1 = (Language1)theEObject;
				T result = caseLanguage1(language1);
				if (result == null) result = caseNameElement(language1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMA1: {
				LEMA1 lema1 = (LEMA1)theEObject;
				T result = caseLEMA1(lema1);
				if (result == null) result = caseNameElement(lema1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMB1: {
				LEMB1 lemb1 = (LEMB1)theEObject;
				T result = caseLEMB1(lemb1);
				if (result == null) result = caseNameElement(lemb1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMC1: {
				LEMC1 lemc1 = (LEMC1)theEObject;
				T result = caseLEMC1(lemc1);
				if (result == null) result = caseNameElement(lemc1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMD1: {
				LEMD1 lemd1 = (LEMD1)theEObject;
				T result = caseLEMD1(lemd1);
				if (result == null) result = caseNameElement(lemd1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEME1: {
				LEME1 leme1 = (LEME1)theEObject;
				T result = caseLEME1(leme1);
				if (result == null) result = caseNameElement(leme1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMF1: {
				LEMF1 lemf1 = (LEMF1)theEObject;
				T result = caseLEMF1(lemf1);
				if (result == null) result = caseNameElement(lemf1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMG1: {
				LEMG1 lemg1 = (LEMG1)theEObject;
				T result = caseLEMG1(lemg1);
				if (result == null) result = caseNameElement(lemg1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMH1: {
				LEMH1 lemh1 = (LEMH1)theEObject;
				T result = caseLEMH1(lemh1);
				if (result == null) result = caseNameElement(lemh1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMI1: {
				LEMI1 lemi1 = (LEMI1)theEObject;
				T result = caseLEMI1(lemi1);
				if (result == null) result = caseNameElement(lemi1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMJ1: {
				LEMJ1 lemj1 = (LEMJ1)theEObject;
				T result = caseLEMJ1(lemj1);
				if (result == null) result = caseNameElement(lemj1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEMK1: {
				LEMK1 lemk1 = (LEMK1)theEObject;
				T result = caseLEMK1(lemk1);
				if (result == null) result = caseNameElement(lemk1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.LEML1: {
				LEML1 leml1 = (LEML1)theEObject;
				T result = caseLEML1(leml1);
				if (result == null) result = caseNameElement(leml1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Language1Package.NAME_ELEMENT: {
				NameElement nameElement = (NameElement)theEObject;
				T result = caseNameElement(nameElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguage1(Language1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMA1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMA1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMA1(LEMA1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMB1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMB1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMB1(LEMB1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMC1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMC1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMC1(LEMC1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMD1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMD1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMD1(LEMD1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEME1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEME1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEME1(LEME1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMF1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMF1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMF1(LEMF1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMG1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMG1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMG1(LEMG1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMH1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMH1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMH1(LEMH1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMI1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMI1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMI1(LEMI1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMJ1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMJ1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMJ1(LEMJ1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEMK1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEMK1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEMK1(LEMK1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LEML1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LEML1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLEML1(LEML1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameElement(NameElement object) {
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

} //Language1Switch
