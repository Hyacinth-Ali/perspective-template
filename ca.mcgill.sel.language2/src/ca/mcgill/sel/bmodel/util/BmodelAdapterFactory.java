/**
 */
package ca.mcgill.sel.bmodel.util;

import ca.mcgill.sel.bmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.mcgill.sel.bmodel.BmodelPackage
 * @generated
 */
public class BmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BmodelPackage.eINSTANCE;
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
	protected BmodelSwitch<Adapter> modelSwitch =
		new BmodelSwitch<Adapter>() {
			@Override
			public Adapter caseBModel(BModel object) {
				return createBModelAdapter();
			}
			@Override
			public Adapter caseB1(B1 object) {
				return createB1Adapter();
			}
			@Override
			public Adapter caseB2(B2 object) {
				return createB2Adapter();
			}
			@Override
			public Adapter caseB3(B3 object) {
				return createB3Adapter();
			}
			@Override
			public Adapter caseB4(B4 object) {
				return createB4Adapter();
			}
			@Override
			public Adapter caseB5(B5 object) {
				return createB5Adapter();
			}
			@Override
			public Adapter caseB6(B6 object) {
				return createB6Adapter();
			}
			@Override
			public Adapter caseB7(B7 object) {
				return createB7Adapter();
			}
			@Override
			public Adapter caseB8(B8 object) {
				return createB8Adapter();
			}
			@Override
			public Adapter caseB9(B9 object) {
				return createB9Adapter();
			}
			@Override
			public Adapter caseB10(B10 object) {
				return createB10Adapter();
			}
			@Override
			public Adapter caseB11(B11 object) {
				return createB11Adapter();
			}
			@Override
			public Adapter caseB12(B12 object) {
				return createB12Adapter();
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
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.BModel <em>BModel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.BModel
	 * @generated
	 */
	public Adapter createBModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B1 <em>B1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B1
	 * @generated
	 */
	public Adapter createB1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B2 <em>B2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B2
	 * @generated
	 */
	public Adapter createB2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B3 <em>B3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B3
	 * @generated
	 */
	public Adapter createB3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B4 <em>B4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B4
	 * @generated
	 */
	public Adapter createB4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B5 <em>B5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B5
	 * @generated
	 */
	public Adapter createB5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B6 <em>B6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B6
	 * @generated
	 */
	public Adapter createB6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B7 <em>B7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B7
	 * @generated
	 */
	public Adapter createB7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B8 <em>B8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B8
	 * @generated
	 */
	public Adapter createB8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B9 <em>B9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B9
	 * @generated
	 */
	public Adapter createB9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B10 <em>B10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B10
	 * @generated
	 */
	public Adapter createB10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B11 <em>B11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B11
	 * @generated
	 */
	public Adapter createB11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.B12 <em>B12</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.B12
	 * @generated
	 */
	public Adapter createB12Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcgill.sel.bmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcgill.sel.bmodel.NamedElement
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

} //BmodelAdapterFactory
