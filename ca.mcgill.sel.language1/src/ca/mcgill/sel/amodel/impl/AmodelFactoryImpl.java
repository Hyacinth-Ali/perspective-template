/**
 */
package ca.mcgill.sel.amodel.impl;

import ca.mcgill.sel.amodel.*;

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
public class AmodelFactoryImpl extends EFactoryImpl implements AmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AmodelFactory init() {
		try {
			AmodelFactory theAmodelFactory = (AmodelFactory)EPackage.Registry.INSTANCE.getEFactory(AmodelPackage.eNS_URI);
			if (theAmodelFactory != null) {
				return theAmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AmodelFactoryImpl() {
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
			case AmodelPackage.AMODEL: return createAModel();
			case AmodelPackage.A1: return createA1();
			case AmodelPackage.A2: return createA2();
			case AmodelPackage.A3: return createA3();
			case AmodelPackage.A4: return createA4();
			case AmodelPackage.A5: return createA5();
			case AmodelPackage.A6: return createA6();
			case AmodelPackage.A7: return createA7();
			case AmodelPackage.A8: return createA8();
			case AmodelPackage.A9: return createA9();
			case AmodelPackage.A10: return createA10();
			case AmodelPackage.A11: return createA11();
			case AmodelPackage.A12: return createA12();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AModel createAModel() {
		AModelImpl aModel = new AModelImpl();
		return aModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A1 createA1() {
		A1Impl a1 = new A1Impl();
		return a1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A2 createA2() {
		A2Impl a2 = new A2Impl();
		return a2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A3 createA3() {
		A3Impl a3 = new A3Impl();
		return a3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A4 createA4() {
		A4Impl a4 = new A4Impl();
		return a4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A5 createA5() {
		A5Impl a5 = new A5Impl();
		return a5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A6 createA6() {
		A6Impl a6 = new A6Impl();
		return a6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A7 createA7() {
		A7Impl a7 = new A7Impl();
		return a7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A8 createA8() {
		A8Impl a8 = new A8Impl();
		return a8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A9 createA9() {
		A9Impl a9 = new A9Impl();
		return a9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 createA10() {
		A10Impl a10 = new A10Impl();
		return a10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A11 createA11() {
		A11Impl a11 = new A11Impl();
		return a11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A12 createA12() {
		A12Impl a12 = new A12Impl();
		return a12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AmodelPackage getAmodelPackage() {
		return (AmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AmodelPackage getPackage() {
		return AmodelPackage.eINSTANCE;
	}

} //AmodelFactoryImpl
