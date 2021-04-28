/**
 */
package ca.mcgill.sel.amodel;

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
 * @see ca.mcgill.sel.amodel.AmodelFactory
 * @model kind="package"
 * @generated
 */
public interface AmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "amodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs.mcgill.ca/sel/amodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "amodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AmodelPackage eINSTANCE = ca.mcgill.sel.amodel.impl.AmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.NamedElementImpl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.AModelImpl <em>AModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.AModelImpl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getAModel()
	 * @generated
	 */
	int AMODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>A1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A1S = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>A2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A2S = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>A5s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A5S = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>A3s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A3S = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>A1 2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A12S = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>A6s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A6S = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>A4s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A4S = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>A7s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A7S = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>A1 1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A11S = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>A1 0s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A10S = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>A9s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A9S = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>A8s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__A8S = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>AModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>AModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A1Impl <em>A1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A1Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA1()
	 * @generated
	 */
	int A1 = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A2Impl <em>A2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A2Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA2()
	 * @generated
	 */
	int A2 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A3Impl <em>A3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A3Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA3()
	 * @generated
	 */
	int A3 = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A4Impl <em>A4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A4Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA4()
	 * @generated
	 */
	int A4 = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A5Impl <em>A5</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A5Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA5()
	 * @generated
	 */
	int A5 = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A5</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A5</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A6Impl <em>A6</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A6Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA6()
	 * @generated
	 */
	int A6 = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A6__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A6_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A6_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A7Impl <em>A7</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A7Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA7()
	 * @generated
	 */
	int A7 = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A7__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A7</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A7_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A7</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A7_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A8Impl <em>A8</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A8Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA8()
	 * @generated
	 */
	int A8 = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A8</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A8_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A9Impl <em>A9</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A9Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA9()
	 * @generated
	 */
	int A9 = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A9__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A9</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A9_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A9</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A9_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A10Impl <em>A10</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A10Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA10()
	 * @generated
	 */
	int A10 = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A11Impl <em>A11</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A11Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA11()
	 * @generated
	 */
	int A11 = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A11__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A11</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A11_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A11</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A11_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.amodel.impl.A12Impl <em>A12</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.amodel.impl.A12Impl
	 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA12()
	 * @generated
	 */
	int A12 = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A12__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>A12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A12_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A12_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.AModel <em>AModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AModel</em>'.
	 * @see ca.mcgill.sel.amodel.AModel
	 * @generated
	 */
	EClass getAModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA1s <em>A1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A1s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA1s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA2s <em>A2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A2s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA2s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A2s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA5s <em>A5s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A5s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA5s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A5s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA3s <em>A3s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A3s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA3s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A3s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA12s <em>A1 2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A1 2s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA12s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A12s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA6s <em>A6s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A6s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA6s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A6s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA4s <em>A4s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A4s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA4s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A4s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA7s <em>A7s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A7s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA7s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A7s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA11s <em>A1 1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A1 1s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA11s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A11s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA10s <em>A1 0s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A1 0s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA10s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A10s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA9s <em>A9s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A9s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA9s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A9s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.amodel.AModel#getA8s <em>A8s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A8s</em>'.
	 * @see ca.mcgill.sel.amodel.AModel#getA8s()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_A8s();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A1 <em>A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A1</em>'.
	 * @see ca.mcgill.sel.amodel.A1
	 * @generated
	 */
	EClass getA1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A2 <em>A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A2</em>'.
	 * @see ca.mcgill.sel.amodel.A2
	 * @generated
	 */
	EClass getA2();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A3 <em>A3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A3</em>'.
	 * @see ca.mcgill.sel.amodel.A3
	 * @generated
	 */
	EClass getA3();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A4 <em>A4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A4</em>'.
	 * @see ca.mcgill.sel.amodel.A4
	 * @generated
	 */
	EClass getA4();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A5 <em>A5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A5</em>'.
	 * @see ca.mcgill.sel.amodel.A5
	 * @generated
	 */
	EClass getA5();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A6 <em>A6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A6</em>'.
	 * @see ca.mcgill.sel.amodel.A6
	 * @generated
	 */
	EClass getA6();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A7 <em>A7</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A7</em>'.
	 * @see ca.mcgill.sel.amodel.A7
	 * @generated
	 */
	EClass getA7();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A8 <em>A8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A8</em>'.
	 * @see ca.mcgill.sel.amodel.A8
	 * @generated
	 */
	EClass getA8();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A9 <em>A9</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A9</em>'.
	 * @see ca.mcgill.sel.amodel.A9
	 * @generated
	 */
	EClass getA9();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A10 <em>A10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A10</em>'.
	 * @see ca.mcgill.sel.amodel.A10
	 * @generated
	 */
	EClass getA10();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A11 <em>A11</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A11</em>'.
	 * @see ca.mcgill.sel.amodel.A11
	 * @generated
	 */
	EClass getA11();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.A12 <em>A12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A12</em>'.
	 * @see ca.mcgill.sel.amodel.A12
	 * @generated
	 */
	EClass getA12();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.amodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see ca.mcgill.sel.amodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcgill.sel.amodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.mcgill.sel.amodel.NamedElement#getName()
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
	AmodelFactory getAmodelFactory();

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
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.AModelImpl <em>AModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.AModelImpl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getAModel()
		 * @generated
		 */
		EClass AMODEL = eINSTANCE.getAModel();

		/**
		 * The meta object literal for the '<em><b>A1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A1S = eINSTANCE.getAModel_A1s();

		/**
		 * The meta object literal for the '<em><b>A2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A2S = eINSTANCE.getAModel_A2s();

		/**
		 * The meta object literal for the '<em><b>A5s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A5S = eINSTANCE.getAModel_A5s();

		/**
		 * The meta object literal for the '<em><b>A3s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A3S = eINSTANCE.getAModel_A3s();

		/**
		 * The meta object literal for the '<em><b>A1 2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A12S = eINSTANCE.getAModel_A12s();

		/**
		 * The meta object literal for the '<em><b>A6s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A6S = eINSTANCE.getAModel_A6s();

		/**
		 * The meta object literal for the '<em><b>A4s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A4S = eINSTANCE.getAModel_A4s();

		/**
		 * The meta object literal for the '<em><b>A7s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A7S = eINSTANCE.getAModel_A7s();

		/**
		 * The meta object literal for the '<em><b>A1 1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A11S = eINSTANCE.getAModel_A11s();

		/**
		 * The meta object literal for the '<em><b>A1 0s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A10S = eINSTANCE.getAModel_A10s();

		/**
		 * The meta object literal for the '<em><b>A9s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A9S = eINSTANCE.getAModel_A9s();

		/**
		 * The meta object literal for the '<em><b>A8s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__A8S = eINSTANCE.getAModel_A8s();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A1Impl <em>A1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A1Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA1()
		 * @generated
		 */
		EClass A1 = eINSTANCE.getA1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A2Impl <em>A2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A2Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA2()
		 * @generated
		 */
		EClass A2 = eINSTANCE.getA2();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A3Impl <em>A3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A3Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA3()
		 * @generated
		 */
		EClass A3 = eINSTANCE.getA3();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A4Impl <em>A4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A4Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA4()
		 * @generated
		 */
		EClass A4 = eINSTANCE.getA4();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A5Impl <em>A5</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A5Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA5()
		 * @generated
		 */
		EClass A5 = eINSTANCE.getA5();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A6Impl <em>A6</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A6Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA6()
		 * @generated
		 */
		EClass A6 = eINSTANCE.getA6();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A7Impl <em>A7</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A7Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA7()
		 * @generated
		 */
		EClass A7 = eINSTANCE.getA7();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A8Impl <em>A8</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A8Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA8()
		 * @generated
		 */
		EClass A8 = eINSTANCE.getA8();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A9Impl <em>A9</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A9Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA9()
		 * @generated
		 */
		EClass A9 = eINSTANCE.getA9();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A10Impl <em>A10</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A10Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA10()
		 * @generated
		 */
		EClass A10 = eINSTANCE.getA10();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A11Impl <em>A11</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A11Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA11()
		 * @generated
		 */
		EClass A11 = eINSTANCE.getA11();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.A12Impl <em>A12</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.A12Impl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getA12()
		 * @generated
		 */
		EClass A12 = eINSTANCE.getA12();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.amodel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.amodel.impl.NamedElementImpl
		 * @see ca.mcgill.sel.amodel.impl.AmodelPackageImpl#getNamedElement()
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

} //AmodelPackage
