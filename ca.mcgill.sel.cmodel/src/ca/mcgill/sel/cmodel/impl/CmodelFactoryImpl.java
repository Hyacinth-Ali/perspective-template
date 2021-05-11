/**
 */
package ca.mcgill.sel.cmodel.impl;

import ca.mcgill.sel.cmodel.*;

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
public class CmodelFactoryImpl extends EFactoryImpl implements CmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CmodelFactory init() {
		try {
			CmodelFactory theCmodelFactory = (CmodelFactory)EPackage.Registry.INSTANCE.getEFactory(CmodelPackage.eNS_URI);
			if (theCmodelFactory != null) {
				return theCmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmodelFactoryImpl() {
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
			case CmodelPackage.CMODEL: return createCModel();
			case CmodelPackage.C1: return createC1();
			case CmodelPackage.C2: return createC2();
			case CmodelPackage.C3: return createC3();
			case CmodelPackage.C4: return createC4();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CModel createCModel() {
		CModelImpl cModel = new CModelImpl();
		return cModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C1 createC1() {
		C1Impl c1 = new C1Impl();
		return c1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C2 createC2() {
		C2Impl c2 = new C2Impl();
		return c2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C3 createC3() {
		C3Impl c3 = new C3Impl();
		return c3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C4 createC4() {
		C4Impl c4 = new C4Impl();
		return c4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmodelPackage getCmodelPackage() {
		return (CmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CmodelPackage getPackage() {
		return CmodelPackage.eINSTANCE;
	}

} //CmodelFactoryImpl
