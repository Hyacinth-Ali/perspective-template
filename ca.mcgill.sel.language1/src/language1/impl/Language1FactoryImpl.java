/**
 */
package language1.impl;

import language1.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Language1FactoryImpl extends EFactoryImpl implements Language1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Language1Factory init() {
		try {
			Language1Factory theLanguage1Factory = (Language1Factory)EPackage.Registry.INSTANCE.getEFactory(Language1Package.eNS_URI);
			if (theLanguage1Factory != null) {
				return theLanguage1Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Language1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language1FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Language1Package.LANGUAGE1: return createLanguage1();
			case Language1Package.LEMA1: return createLEMA1();
			case Language1Package.LEMB1: return createLEMB1();
			case Language1Package.LEMC1: return createLEMC1();
			case Language1Package.LEMD1: return createLEMD1();
			case Language1Package.LEME1: return createLEME1();
			case Language1Package.LEMF1: return createLEMF1();
			case Language1Package.LEMG1: return createLEMG1();
			case Language1Package.LEMH1: return createLEMH1();
			case Language1Package.LEMI1: return createLEMI1();
			case Language1Package.LEMJ1: return createLEMJ1();
			case Language1Package.LEMK1: return createLEMK1();
			case Language1Package.LEML1: return createLEML1();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language1 createLanguage1() {
		Language1Impl language1 = new Language1Impl();
		return language1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMA1 createLEMA1() {
		LEMA1Impl lema1 = new LEMA1Impl();
		return lema1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMB1 createLEMB1() {
		LEMB1Impl lemb1 = new LEMB1Impl();
		return lemb1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMC1 createLEMC1() {
		LEMC1Impl lemc1 = new LEMC1Impl();
		return lemc1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMD1 createLEMD1() {
		LEMD1Impl lemd1 = new LEMD1Impl();
		return lemd1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEME1 createLEME1() {
		LEME1Impl leme1 = new LEME1Impl();
		return leme1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMF1 createLEMF1() {
		LEMF1Impl lemf1 = new LEMF1Impl();
		return lemf1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMG1 createLEMG1() {
		LEMG1Impl lemg1 = new LEMG1Impl();
		return lemg1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMH1 createLEMH1() {
		LEMH1Impl lemh1 = new LEMH1Impl();
		return lemh1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMI1 createLEMI1() {
		LEMI1Impl lemi1 = new LEMI1Impl();
		return lemi1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMJ1 createLEMJ1() {
		LEMJ1Impl lemj1 = new LEMJ1Impl();
		return lemj1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMK1 createLEMK1() {
		LEMK1Impl lemk1 = new LEMK1Impl();
		return lemk1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEML1 createLEML1() {
		LEML1Impl leml1 = new LEML1Impl();
		return leml1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language1Package getLanguage1Package() {
		return (Language1Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Language1Package getPackage() {
		return Language1Package.eINSTANCE;
	}

} //Language1FactoryImpl
