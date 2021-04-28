/**
 */
package ca.mcgill.sel.amodel.util;

import ca.mcgill.sel.amodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.mcgill.sel.amodel.AmodelPackage
 * @generated
 */
public class AmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AmodelSwitch<Adapter> modelSwitch =
		new AmodelSwitch<Adapter>() {
			@Override
			public Adapter caseAModel(AModel object) {
				return createAModelAdapter();
			}
			@Override
			public Adapter caseA1(A1 object) {
				return createA1Adapter();
			}
			@Override
			public Adapter caseA2(A2 object) {
				return createA2Adapter();
			}
			@Override
			public Adapter caseA3(A3 object) {
				return createA3Adapter();
			}
			@Override
			public Adapter caseA4(A4 object) {
				return createA4Adapter();
			}
			@Override
			public Adapter caseA5(A5 object) {
				return createA5Adapter();
			}
			@Override
			public Adapter caseA6(A6 object) {
				return createA6Adapter();
			}
			@Override
			public Adapter caseA7(A7 object) {
				return createA7Adapter();
			}
			@Override
			public Adapter caseA8(A8 object) {
				return createA8Adapter();
			}
			@Override
			public Adapter caseA9(A9 object) {
				return createA9Adapter();
			}
			@Override
			public Adapter caseA10(A10 object) {
				return createA10Adapter();
			}
			@Override
			public Adapter caseA11(A11 object) {
				return createA11Adapter();
			}
			@Override
			public Adapter caseA12(A12 object) {
				return createA12Adapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.AModel <em>AModel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.AModel
	 * @generated
	 */
	public Adapter createAModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A1 <em>A1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A1
	 * @generated
	 */
	public Adapter createA1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A2 <em>A2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A2
	 * @generated
	 */
	public Adapter createA2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A3 <em>A3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A3
	 * @generated
	 */
	public Adapter createA3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A4 <em>A4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A4
	 * @generated
	 */
	public Adapter createA4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A5 <em>A5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A5
	 * @generated
	 */
	public Adapter createA5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A6 <em>A6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A6
	 * @generated
	 */
	public Adapter createA6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A7 <em>A7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A7
	 * @generated
	 */
	public Adapter createA7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A8 <em>A8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A8
	 * @generated
	 */
	public Adapter createA8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A9 <em>A9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A9
	 * @generated
	 */
	public Adapter createA9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A10 <em>A10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A10
	 * @generated
	 */
	public Adapter createA10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A11 <em>A11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A11
	 * @generated
	 */
	public Adapter createA11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.A12 <em>A12</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.A12
	 * @generated
	 */
	public Adapter createA12Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.amodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.amodel.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AmodelAdapterFactory
