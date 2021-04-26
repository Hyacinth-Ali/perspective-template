/**
 */
package language1.util;

import language1.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see language1.Language1Package
 * @generated
 */
public class Language1AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Language1Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language1AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Language1Package.eINSTANCE;
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
	protected Language1Switch<Adapter> modelSwitch =
		new Language1Switch<Adapter>() {
			@Override
			public Adapter caseLanguage1(Language1 object) {
				return createLanguage1Adapter();
			}
			@Override
			public Adapter caseLEMA1(LEMA1 object) {
				return createLEMA1Adapter();
			}
			@Override
			public Adapter caseLEMB1(LEMB1 object) {
				return createLEMB1Adapter();
			}
			@Override
			public Adapter caseLEMC1(LEMC1 object) {
				return createLEMC1Adapter();
			}
			@Override
			public Adapter caseLEMD1(LEMD1 object) {
				return createLEMD1Adapter();
			}
			@Override
			public Adapter caseLEME1(LEME1 object) {
				return createLEME1Adapter();
			}
			@Override
			public Adapter caseLEMF1(LEMF1 object) {
				return createLEMF1Adapter();
			}
			@Override
			public Adapter caseLEMG1(LEMG1 object) {
				return createLEMG1Adapter();
			}
			@Override
			public Adapter caseLEMH1(LEMH1 object) {
				return createLEMH1Adapter();
			}
			@Override
			public Adapter caseLEMI1(LEMI1 object) {
				return createLEMI1Adapter();
			}
			@Override
			public Adapter caseLEMJ1(LEMJ1 object) {
				return createLEMJ1Adapter();
			}
			@Override
			public Adapter caseLEMK1(LEMK1 object) {
				return createLEMK1Adapter();
			}
			@Override
			public Adapter caseLEML1(LEML1 object) {
				return createLEML1Adapter();
			}
			@Override
			public Adapter caseNameElement(NameElement object) {
				return createNameElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link language1.Language1 <em>Language1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.Language1
	 * @generated
	 */
	public Adapter createLanguage1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMA1 <em>LEMA1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMA1
	 * @generated
	 */
	public Adapter createLEMA1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMB1 <em>LEMB1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMB1
	 * @generated
	 */
	public Adapter createLEMB1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMC1 <em>LEMC1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMC1
	 * @generated
	 */
	public Adapter createLEMC1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMD1 <em>LEMD1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMD1
	 * @generated
	 */
	public Adapter createLEMD1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEME1 <em>LEME1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEME1
	 * @generated
	 */
	public Adapter createLEME1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMF1 <em>LEMF1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMF1
	 * @generated
	 */
	public Adapter createLEMF1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMG1 <em>LEMG1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMG1
	 * @generated
	 */
	public Adapter createLEMG1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMH1 <em>LEMH1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMH1
	 * @generated
	 */
	public Adapter createLEMH1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMI1 <em>LEMI1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMI1
	 * @generated
	 */
	public Adapter createLEMI1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMJ1 <em>LEMJ1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMJ1
	 * @generated
	 */
	public Adapter createLEMJ1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEMK1 <em>LEMK1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEMK1
	 * @generated
	 */
	public Adapter createLEMK1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.LEML1 <em>LEML1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.LEML1
	 * @generated
	 */
	public Adapter createLEML1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link language1.NameElement <em>Name Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see language1.NameElement
	 * @generated
	 */
	public Adapter createNameElementAdapter() {
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

} //Language1AdapterFactory
