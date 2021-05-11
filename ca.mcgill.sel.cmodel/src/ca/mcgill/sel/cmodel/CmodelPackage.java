/**
 */
package ca.mcgill.sel.cmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ca.mcgill.sel.cmodel.CmodelFactory
 * @model kind="package"
 * @generated
 */
public interface CmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs.mcgill.ca/sel/cmodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CmodelPackage eINSTANCE = ca.mcgill.sel.cmodel.impl.CmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.cmodel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.cmodel.impl.NamedElementImpl
	 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.cmodel.impl.CModelImpl <em>CModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.cmodel.impl.CModelImpl
	 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getCModel()
	 * @generated
	 */
	int CMODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>C1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL__C1S = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>C2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL__C2S = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>C3s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL__C3S = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>C4s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL__C4S = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>CModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.cmodel.impl.C1Impl <em>C1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.cmodel.impl.C1Impl
	 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC1()
	 * @generated
	 */
	int C1 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>C1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>C1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.cmodel.impl.C2Impl <em>C2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.cmodel.impl.C2Impl
	 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC2()
	 * @generated
	 */
	int C2 = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C2__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>C2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C2_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>C2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C2_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.cmodel.impl.C3Impl <em>C3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.cmodel.impl.C3Impl
	 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC3()
	 * @generated
	 */
	int C3 = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C3__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>C3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C3_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>C3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C3_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.cmodel.impl.C4Impl <em>C4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.cmodel.impl.C4Impl
	 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC4()
	 * @generated
	 */
	int C4 = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>C4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>C4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.cmodel.CModel <em>CModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CModel</em>'.
	 * @see ca.mcgill.sel.cmodel.CModel
	 * @generated
	 */
	EClass getCModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.cmodel.CModel#getC1s <em>C1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>C1s</em>'.
	 * @see ca.mcgill.sel.cmodel.CModel#getC1s()
	 * @see #getCModel()
	 * @generated
	 */
	EReference getCModel_C1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.cmodel.CModel#getC2s <em>C2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>C2s</em>'.
	 * @see ca.mcgill.sel.cmodel.CModel#getC2s()
	 * @see #getCModel()
	 * @generated
	 */
	EReference getCModel_C2s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.cmodel.CModel#getC3s <em>C3s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>C3s</em>'.
	 * @see ca.mcgill.sel.cmodel.CModel#getC3s()
	 * @see #getCModel()
	 * @generated
	 */
	EReference getCModel_C3s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.cmodel.CModel#getC4s <em>C4s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>C4s</em>'.
	 * @see ca.mcgill.sel.cmodel.CModel#getC4s()
	 * @see #getCModel()
	 * @generated
	 */
	EReference getCModel_C4s();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.cmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see ca.mcgill.sel.cmodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcgill.sel.cmodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.mcgill.sel.cmodel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.cmodel.C1 <em>C1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C1</em>'.
	 * @see ca.mcgill.sel.cmodel.C1
	 * @generated
	 */
	EClass getC1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.cmodel.C2 <em>C2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C2</em>'.
	 * @see ca.mcgill.sel.cmodel.C2
	 * @generated
	 */
	EClass getC2();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.cmodel.C3 <em>C3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C3</em>'.
	 * @see ca.mcgill.sel.cmodel.C3
	 * @generated
	 */
	EClass getC3();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.cmodel.C4 <em>C4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C4</em>'.
	 * @see ca.mcgill.sel.cmodel.C4
	 * @generated
	 */
	EClass getC4();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CmodelFactory getCmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.cmodel.impl.CModelImpl <em>CModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.cmodel.impl.CModelImpl
		 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getCModel()
		 * @generated
		 */
		EClass CMODEL = eINSTANCE.getCModel();

		/**
		 * The meta object literal for the '<em><b>C1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CMODEL__C1S = eINSTANCE.getCModel_C1s();

		/**
		 * The meta object literal for the '<em><b>C2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CMODEL__C2S = eINSTANCE.getCModel_C2s();

		/**
		 * The meta object literal for the '<em><b>C3s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CMODEL__C3S = eINSTANCE.getCModel_C3s();

		/**
		 * The meta object literal for the '<em><b>C4s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CMODEL__C4S = eINSTANCE.getCModel_C4s();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.cmodel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.cmodel.impl.NamedElementImpl
		 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.cmodel.impl.C1Impl <em>C1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.cmodel.impl.C1Impl
		 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC1()
		 * @generated
		 */
		EClass C1 = eINSTANCE.getC1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.cmodel.impl.C2Impl <em>C2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.cmodel.impl.C2Impl
		 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC2()
		 * @generated
		 */
		EClass C2 = eINSTANCE.getC2();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.cmodel.impl.C3Impl <em>C3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.cmodel.impl.C3Impl
		 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC3()
		 * @generated
		 */
		EClass C3 = eINSTANCE.getC3();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.cmodel.impl.C4Impl <em>C4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.cmodel.impl.C4Impl
		 * @see ca.mcgill.sel.cmodel.impl.CmodelPackageImpl#getC4()
		 * @generated
		 */
		EClass C4 = eINSTANCE.getC4();

	}

} //CmodelPackage
