/**
 */
package ca.mcgill.sel.bmodel;

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
 * @see ca.mcgill.sel.bmodel.BmodelFactory
 * @model kind="package"
 * @generated
 */
public interface BmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs.mcgill.ca/sel/bmodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BmodelPackage eINSTANCE = ca.mcgill.sel.bmodel.impl.BmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.NamedElementImpl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 13;

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
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.BModelImpl <em>BModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.BModelImpl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getBModel()
	 * @generated
	 */
	int BMODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>B1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B1S = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>B2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B2S = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>B5s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B5S = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>B3s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B3S = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>B1 2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B12S = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>B6s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B6S = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>B4s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B4S = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>B7s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B7S = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>B1 1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B11S = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>B1 0s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B10S = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>B9s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B9S = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>B8s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL__B8S = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>BModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>BModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B1Impl <em>B1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B1Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB1()
	 * @generated
	 */
	int B1 = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B2Impl <em>B2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B2Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB2()
	 * @generated
	 */
	int B2 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B2__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B2_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B2_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B3Impl <em>B3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B3Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB3()
	 * @generated
	 */
	int B3 = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B4Impl <em>B4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B4Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB4()
	 * @generated
	 */
	int B4 = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B4__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B4_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B4_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B5Impl <em>B5</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B5Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB5()
	 * @generated
	 */
	int B5 = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B5__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B5</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B5_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B5</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B5_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B6Impl <em>B6</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B6Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB6()
	 * @generated
	 */
	int B6 = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B6__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B6_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B6_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B7Impl <em>B7</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B7Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB7()
	 * @generated
	 */
	int B7 = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B7__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B7</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B7_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B7</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B7_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B8Impl <em>B8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B8Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB8()
	 * @generated
	 */
	int B8 = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B8_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B9Impl <em>B9</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B9Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB9()
	 * @generated
	 */
	int B9 = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B9__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B9</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B9_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B9</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B9_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B10Impl <em>B10</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B10Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB10()
	 * @generated
	 */
	int B10 = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B10__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B10_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B10_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B11Impl <em>B11</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B11Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB11()
	 * @generated
	 */
	int B11 = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B11__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B11</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B11_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B11</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B11_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.bmodel.impl.B12Impl <em>B12</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.bmodel.impl.B12Impl
	 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB12()
	 * @generated
	 */
	int B12 = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B12__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>B12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B12_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>B12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B12_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.BModel <em>BModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BModel</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel
	 * @generated
	 */
	EClass getBModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB1s <em>B1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B1s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB1s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB2s <em>B2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B2s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB2s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B2s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB5s <em>B5s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B5s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB5s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B5s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB3s <em>B3s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B3s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB3s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B3s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB12s <em>B1 2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B1 2s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB12s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B12s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB6s <em>B6s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B6s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB6s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B6s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB4s <em>B4s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B4s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB4s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B4s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB7s <em>B7s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B7s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB7s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B7s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB11s <em>B1 1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B1 1s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB11s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B11s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB10s <em>B1 0s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B1 0s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB10s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B10s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB9s <em>B9s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B9s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB9s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B9s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.bmodel.BModel#getB8s <em>B8s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B8s</em>'.
	 * @see ca.mcgill.sel.bmodel.BModel#getB8s()
	 * @see #getBModel()
	 * @generated
	 */
	EReference getBModel_B8s();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B1 <em>B1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B1</em>'.
	 * @see ca.mcgill.sel.bmodel.B1
	 * @generated
	 */
	EClass getB1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B2 <em>B2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B2</em>'.
	 * @see ca.mcgill.sel.bmodel.B2
	 * @generated
	 */
	EClass getB2();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B3 <em>B3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B3</em>'.
	 * @see ca.mcgill.sel.bmodel.B3
	 * @generated
	 */
	EClass getB3();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B4 <em>B4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B4</em>'.
	 * @see ca.mcgill.sel.bmodel.B4
	 * @generated
	 */
	EClass getB4();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B5 <em>B5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B5</em>'.
	 * @see ca.mcgill.sel.bmodel.B5
	 * @generated
	 */
	EClass getB5();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B6 <em>B6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B6</em>'.
	 * @see ca.mcgill.sel.bmodel.B6
	 * @generated
	 */
	EClass getB6();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B7 <em>B7</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B7</em>'.
	 * @see ca.mcgill.sel.bmodel.B7
	 * @generated
	 */
	EClass getB7();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B8 <em>B8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B8</em>'.
	 * @see ca.mcgill.sel.bmodel.B8
	 * @generated
	 */
	EClass getB8();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B9 <em>B9</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B9</em>'.
	 * @see ca.mcgill.sel.bmodel.B9
	 * @generated
	 */
	EClass getB9();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B10 <em>B10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B10</em>'.
	 * @see ca.mcgill.sel.bmodel.B10
	 * @generated
	 */
	EClass getB10();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B11 <em>B11</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B11</em>'.
	 * @see ca.mcgill.sel.bmodel.B11
	 * @generated
	 */
	EClass getB11();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.B12 <em>B12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B12</em>'.
	 * @see ca.mcgill.sel.bmodel.B12
	 * @generated
	 */
	EClass getB12();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.bmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see ca.mcgill.sel.bmodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcgill.sel.bmodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.mcgill.sel.bmodel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BmodelFactory getBmodelFactory();

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
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.BModelImpl <em>BModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.BModelImpl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getBModel()
		 * @generated
		 */
		EClass BMODEL = eINSTANCE.getBModel();

		/**
		 * The meta object literal for the '<em><b>B1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B1S = eINSTANCE.getBModel_B1s();

		/**
		 * The meta object literal for the '<em><b>B2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B2S = eINSTANCE.getBModel_B2s();

		/**
		 * The meta object literal for the '<em><b>B5s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B5S = eINSTANCE.getBModel_B5s();

		/**
		 * The meta object literal for the '<em><b>B3s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B3S = eINSTANCE.getBModel_B3s();

		/**
		 * The meta object literal for the '<em><b>B1 2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B12S = eINSTANCE.getBModel_B12s();

		/**
		 * The meta object literal for the '<em><b>B6s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B6S = eINSTANCE.getBModel_B6s();

		/**
		 * The meta object literal for the '<em><b>B4s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B4S = eINSTANCE.getBModel_B4s();

		/**
		 * The meta object literal for the '<em><b>B7s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B7S = eINSTANCE.getBModel_B7s();

		/**
		 * The meta object literal for the '<em><b>B1 1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B11S = eINSTANCE.getBModel_B11s();

		/**
		 * The meta object literal for the '<em><b>B1 0s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B10S = eINSTANCE.getBModel_B10s();

		/**
		 * The meta object literal for the '<em><b>B9s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B9S = eINSTANCE.getBModel_B9s();

		/**
		 * The meta object literal for the '<em><b>B8s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMODEL__B8S = eINSTANCE.getBModel_B8s();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B1Impl <em>B1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B1Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB1()
		 * @generated
		 */
		EClass B1 = eINSTANCE.getB1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B2Impl <em>B2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B2Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB2()
		 * @generated
		 */
		EClass B2 = eINSTANCE.getB2();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B3Impl <em>B3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B3Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB3()
		 * @generated
		 */
		EClass B3 = eINSTANCE.getB3();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B4Impl <em>B4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B4Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB4()
		 * @generated
		 */
		EClass B4 = eINSTANCE.getB4();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B5Impl <em>B5</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B5Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB5()
		 * @generated
		 */
		EClass B5 = eINSTANCE.getB5();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B6Impl <em>B6</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B6Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB6()
		 * @generated
		 */
		EClass B6 = eINSTANCE.getB6();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B7Impl <em>B7</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B7Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB7()
		 * @generated
		 */
		EClass B7 = eINSTANCE.getB7();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B8Impl <em>B8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B8Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB8()
		 * @generated
		 */
		EClass B8 = eINSTANCE.getB8();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B9Impl <em>B9</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B9Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB9()
		 * @generated
		 */
		EClass B9 = eINSTANCE.getB9();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B10Impl <em>B10</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B10Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB10()
		 * @generated
		 */
		EClass B10 = eINSTANCE.getB10();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B11Impl <em>B11</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B11Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB11()
		 * @generated
		 */
		EClass B11 = eINSTANCE.getB11();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.B12Impl <em>B12</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.B12Impl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getB12()
		 * @generated
		 */
		EClass B12 = eINSTANCE.getB12();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.bmodel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.bmodel.impl.NamedElementImpl
		 * @see ca.mcgill.sel.bmodel.impl.BmodelPackageImpl#getNamedElement()
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

	}

} //BmodelPackage
