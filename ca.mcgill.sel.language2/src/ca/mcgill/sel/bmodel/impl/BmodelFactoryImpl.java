/**
 */
package ca.mcgill.sel.bmodel.impl;

import ca.mcgill.sel.bmodel.*;

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
public class BmodelFactoryImpl extends EFactoryImpl implements BmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BmodelFactory init() {
		try {
			BmodelFactory theBmodelFactory = (BmodelFactory)EPackage.Registry.INSTANCE.getEFactory(BmodelPackage.eNS_URI);
			if (theBmodelFactory != null) {
				return theBmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmodelFactoryImpl() {
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
			case BmodelPackage.BMODEL: return createBModel();
			case BmodelPackage.B1: return createB1();
			case BmodelPackage.B2: return createB2();
			case BmodelPackage.B3: return createB3();
			case BmodelPackage.B4: return createB4();
			case BmodelPackage.B5: return createB5();
			case BmodelPackage.B6: return createB6();
			case BmodelPackage.B7: return createB7();
			case BmodelPackage.B8: return createB8();
			case BmodelPackage.B9: return createB9();
			case BmodelPackage.B10: return createB10();
			case BmodelPackage.B11: return createB11();
			case BmodelPackage.B12: return createB12();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BModel createBModel() {
		BModelImpl bModel = new BModelImpl();
		return bModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B1 createB1() {
		B1Impl b1 = new B1Impl();
		return b1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B2 createB2() {
		B2Impl b2 = new B2Impl();
		return b2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3 createB3() {
		B3Impl b3 = new B3Impl();
		return b3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 createB4() {
		B4Impl b4 = new B4Impl();
		return b4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B5 createB5() {
		B5Impl b5 = new B5Impl();
		return b5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B6 createB6() {
		B6Impl b6 = new B6Impl();
		return b6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B7 createB7() {
		B7Impl b7 = new B7Impl();
		return b7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B8 createB8() {
		B8Impl b8 = new B8Impl();
		return b8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B9 createB9() {
		B9Impl b9 = new B9Impl();
		return b9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 createB10() {
		B10Impl b10 = new B10Impl();
		return b10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B11 createB11() {
		B11Impl b11 = new B11Impl();
		return b11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B12 createB12() {
		B12Impl b12 = new B12Impl();
		return b12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmodelPackage getBmodelPackage() {
		return (BmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BmodelPackage getPackage() {
		return BmodelPackage.eINSTANCE;
	}

} //BmodelFactoryImpl
