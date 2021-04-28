/**
 */
package ca.mcgill.sel.bmodel.util;

import ca.mcgill.sel.bmodel.*;

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
 * @see ca.mcgill.sel.bmodel.BmodelPackage
 * @generated
 */
public class BmodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = BmodelPackage.eINSTANCE;
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
			case BmodelPackage.BMODEL: {
				BModel bModel = (BModel)theEObject;
				T result = caseBModel(bModel);
				if (result == null) result = caseNamedElement(bModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B1: {
				B1 b1 = (B1)theEObject;
				T result = caseB1(b1);
				if (result == null) result = caseNamedElement(b1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B2: {
				B2 b2 = (B2)theEObject;
				T result = caseB2(b2);
				if (result == null) result = caseNamedElement(b2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B3: {
				B3 b3 = (B3)theEObject;
				T result = caseB3(b3);
				if (result == null) result = caseNamedElement(b3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B4: {
				B4 b4 = (B4)theEObject;
				T result = caseB4(b4);
				if (result == null) result = caseNamedElement(b4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B5: {
				B5 b5 = (B5)theEObject;
				T result = caseB5(b5);
				if (result == null) result = caseNamedElement(b5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B6: {
				B6 b6 = (B6)theEObject;
				T result = caseB6(b6);
				if (result == null) result = caseNamedElement(b6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B7: {
				B7 b7 = (B7)theEObject;
				T result = caseB7(b7);
				if (result == null) result = caseNamedElement(b7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B8: {
				B8 b8 = (B8)theEObject;
				T result = caseB8(b8);
				if (result == null) result = caseNamedElement(b8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B9: {
				B9 b9 = (B9)theEObject;
				T result = caseB9(b9);
				if (result == null) result = caseNamedElement(b9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B10: {
				B10 b10 = (B10)theEObject;
				T result = caseB10(b10);
				if (result == null) result = caseNamedElement(b10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B11: {
				B11 b11 = (B11)theEObject;
				T result = caseB11(b11);
				if (result == null) result = caseNamedElement(b11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.B12: {
				B12 b12 = (B12)theEObject;
				T result = caseB12(b12);
				if (result == null) result = caseNamedElement(b12);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmodelPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BModel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BModel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBModel(BModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB1(B1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB2(B2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB3(B3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB4(B4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB5(B5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B6</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B6</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB6(B6 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B7</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B7</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB7(B7 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB8(B8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB9(B9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB10(B10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB11(B11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B12</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B12</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB12(B12 object) {
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

} //BmodelSwitch
