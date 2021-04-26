/**
 */
package language2.impl;

import language2.*;

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
public class Language2FactoryImpl extends EFactoryImpl implements Language2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Language2Factory init() {
		try {
			Language2Factory theLanguage2Factory = (Language2Factory)EPackage.Registry.INSTANCE.getEFactory(Language2Package.eNS_URI);
			if (theLanguage2Factory != null) {
				return theLanguage2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Language2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language2FactoryImpl() {
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
			case Language2Package.LANGUAGE2: return createLanguage2();
			case Language2Package.LEMA2: return createLEMA2();
			case Language2Package.LEMB2: return createLEMB2();
			case Language2Package.LEMC2: return createLEMC2();
			case Language2Package.LEMD2: return createLEMD2();
			case Language2Package.LEME2: return createLEME2();
			case Language2Package.LEMF2: return createLEMF2();
			case Language2Package.LEMG2: return createLEMG2();
			case Language2Package.LEMH2: return createLEMH2();
			case Language2Package.LEMI2: return createLEMI2();
			case Language2Package.LEMJ2: return createLEMJ2();
			case Language2Package.LEMK2: return createLEMK2();
			case Language2Package.LEML2: return createLEML2();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language2 createLanguage2() {
		Language2Impl language2 = new Language2Impl();
		return language2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMA2 createLEMA2() {
		LEMA2Impl lema2 = new LEMA2Impl();
		return lema2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMB2 createLEMB2() {
		LEMB2Impl lemb2 = new LEMB2Impl();
		return lemb2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMC2 createLEMC2() {
		LEMC2Impl lemc2 = new LEMC2Impl();
		return lemc2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMD2 createLEMD2() {
		LEMD2Impl lemd2 = new LEMD2Impl();
		return lemd2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEME2 createLEME2() {
		LEME2Impl leme2 = new LEME2Impl();
		return leme2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMF2 createLEMF2() {
		LEMF2Impl lemf2 = new LEMF2Impl();
		return lemf2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMG2 createLEMG2() {
		LEMG2Impl lemg2 = new LEMG2Impl();
		return lemg2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMH2 createLEMH2() {
		LEMH2Impl lemh2 = new LEMH2Impl();
		return lemh2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMI2 createLEMI2() {
		LEMI2Impl lemi2 = new LEMI2Impl();
		return lemi2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMJ2 createLEMJ2() {
		LEMJ2Impl lemj2 = new LEMJ2Impl();
		return lemj2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEMK2 createLEMK2() {
		LEMK2Impl lemk2 = new LEMK2Impl();
		return lemk2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LEML2 createLEML2() {
		LEML2Impl leml2 = new LEML2Impl();
		return leml2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language2Package getLanguage2Package() {
		return (Language2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Language2Package getPackage() {
		return Language2Package.eINSTANCE;
	}

} //Language2FactoryImpl
