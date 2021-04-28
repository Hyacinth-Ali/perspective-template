/**
 */
package ca.mcgill.sel.amodel.util;

import ca.mcgill.sel.amodel.*;

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
 * @see ca.mcgill.sel.amodel.AmodelPackage
 * @generated
 */
public class AmodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = AmodelPackage.eINSTANCE;
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
			case AmodelPackage.AMODEL: {
				AModel aModel = (AModel)theEObject;
				T result = caseAModel(aModel);
				if (result == null) result = caseNamedElement(aModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A1: {
				A1 a1 = (A1)theEObject;
				T result = caseA1(a1);
				if (result == null) result = caseNamedElement(a1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A2: {
				A2 a2 = (A2)theEObject;
				T result = caseA2(a2);
				if (result == null) result = caseNamedElement(a2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A3: {
				A3 a3 = (A3)theEObject;
				T result = caseA3(a3);
				if (result == null) result = caseNamedElement(a3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A4: {
				A4 a4 = (A4)theEObject;
				T result = caseA4(a4);
				if (result == null) result = caseNamedElement(a4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A5: {
				A5 a5 = (A5)theEObject;
				T result = caseA5(a5);
				if (result == null) result = caseNamedElement(a5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A6: {
				A6 a6 = (A6)theEObject;
				T result = caseA6(a6);
				if (result == null) result = caseNamedElement(a6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A7: {
				A7 a7 = (A7)theEObject;
				T result = caseA7(a7);
				if (result == null) result = caseNamedElement(a7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A8: {
				A8 a8 = (A8)theEObject;
				T result = caseA8(a8);
				if (result == null) result = caseNamedElement(a8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A9: {
				A9 a9 = (A9)theEObject;
				T result = caseA9(a9);
				if (result == null) result = caseNamedElement(a9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A10: {
				A10 a10 = (A10)theEObject;
				T result = caseA10(a10);
				if (result == null) result = caseNamedElement(a10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A11: {
				A11 a11 = (A11)theEObject;
				T result = caseA11(a11);
				if (result == null) result = caseNamedElement(a11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.A12: {
				A12 a12 = (A12)theEObject;
				T result = caseA12(a12);
				if (result == null) result = caseNamedElement(a12);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AmodelPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AModel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AModel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAModel(AModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA1(A1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA2(A2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA3(A3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA4(A4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA5(A5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A6</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A6</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA6(A6 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A7</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A7</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA7(A7 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA8(A8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA9(A9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA10(A10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA11(A11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A12</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A12</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA12(A12 object) {
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

} //AmodelSwitch
