/**
 */
package ca.mcgill.sel.language1;

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
 * @see ca.mcgill.sel.language1.Language1Factory
 * @model kind="package"
 * @generated
 */
public interface Language1Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "language1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs.mcgill.ca/sel/language1/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "language1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Language1Package eINSTANCE = ca.mcgill.sel.language1.impl.Language1PackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.NamedElementImpl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.Language1Impl <em>Language1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.Language1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLanguage1()
	 * @generated
	 */
	int LANGUAGE1 = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Lema1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMA1S = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lemb1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMB1S = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Leme1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEME1S = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lemc1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMC1S = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Leml1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEML1S = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Lemf1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMF1S = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Lemd1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMD1S = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Lemg1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMG1S = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Lemk1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMK1S = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Lemj1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMJ1S = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Lemi1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMI1S = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Lemh1s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1__LEMH1S = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Language1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Language1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMA1Impl <em>LEMA1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMA1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMA1()
	 * @generated
	 */
	int LEMA1 = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMA1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMA1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMA1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMA1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMA1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMB1Impl <em>LEMB1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMB1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMB1()
	 * @generated
	 */
	int LEMB1 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMB1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMB1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMB1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMB1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMB1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMC1Impl <em>LEMC1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMC1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMC1()
	 * @generated
	 */
	int LEMC1 = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMC1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMC1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMC1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMC1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMC1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMD1Impl <em>LEMD1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMD1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMD1()
	 * @generated
	 */
	int LEMD1 = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMD1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMD1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMD1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMD1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMD1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEME1Impl <em>LEME1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEME1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEME1()
	 * @generated
	 */
	int LEME1 = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEME1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEME1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEME1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEME1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEME1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMF1Impl <em>LEMF1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMF1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMF1()
	 * @generated
	 */
	int LEMF1 = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMF1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMF1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMF1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMF1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMF1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMG1Impl <em>LEMG1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMG1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMG1()
	 * @generated
	 */
	int LEMG1 = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMG1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMG1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMG1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMG1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMG1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMH1Impl <em>LEMH1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMH1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMH1()
	 * @generated
	 */
	int LEMH1 = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMH1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMH1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMH1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMH1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMH1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMI1Impl <em>LEMI1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMI1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMI1()
	 * @generated
	 */
	int LEMI1 = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMI1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMI1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMI1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMI1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMI1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMJ1Impl <em>LEMJ1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMJ1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMJ1()
	 * @generated
	 */
	int LEMJ1 = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMJ1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMJ1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMJ1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMJ1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMJ1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEMK1Impl <em>LEMK1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEMK1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMK1()
	 * @generated
	 */
	int LEMK1 = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMK1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMK1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMK1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMK1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMK1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcgill.sel.language1.impl.LEML1Impl <em>LEML1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcgill.sel.language1.impl.LEML1Impl
	 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEML1()
	 * @generated
	 */
	int LEML1 = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEML1__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEML1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEML1_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEML1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEML1_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.Language1 <em>Language1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language1</em>'.
	 * @see ca.mcgill.sel.language1.Language1
	 * @generated
	 */
	EClass getLanguage1();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLema1s <em>Lema1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lema1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLema1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lema1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemb1s <em>Lemb1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemb1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemb1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemb1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLeme1s <em>Leme1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leme1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLeme1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Leme1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemc1s <em>Lemc1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemc1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemc1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemc1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLeml1s <em>Leml1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leml1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLeml1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Leml1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemf1s <em>Lemf1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemf1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemf1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemf1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemd1s <em>Lemd1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemd1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemd1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemd1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemg1s <em>Lemg1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemg1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemg1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemg1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemk1s <em>Lemk1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemk1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemk1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemk1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemj1s <em>Lemj1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemj1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemj1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemj1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemi1s <em>Lemi1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemi1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemi1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemi1s();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcgill.sel.language1.Language1#getLemh1s <em>Lemh1s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemh1s</em>'.
	 * @see ca.mcgill.sel.language1.Language1#getLemh1s()
	 * @see #getLanguage1()
	 * @generated
	 */
	EReference getLanguage1_Lemh1s();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMA1 <em>LEMA1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMA1</em>'.
	 * @see ca.mcgill.sel.language1.LEMA1
	 * @generated
	 */
	EClass getLEMA1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMB1 <em>LEMB1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMB1</em>'.
	 * @see ca.mcgill.sel.language1.LEMB1
	 * @generated
	 */
	EClass getLEMB1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMC1 <em>LEMC1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMC1</em>'.
	 * @see ca.mcgill.sel.language1.LEMC1
	 * @generated
	 */
	EClass getLEMC1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMD1 <em>LEMD1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMD1</em>'.
	 * @see ca.mcgill.sel.language1.LEMD1
	 * @generated
	 */
	EClass getLEMD1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEME1 <em>LEME1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEME1</em>'.
	 * @see ca.mcgill.sel.language1.LEME1
	 * @generated
	 */
	EClass getLEME1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMF1 <em>LEMF1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMF1</em>'.
	 * @see ca.mcgill.sel.language1.LEMF1
	 * @generated
	 */
	EClass getLEMF1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMG1 <em>LEMG1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMG1</em>'.
	 * @see ca.mcgill.sel.language1.LEMG1
	 * @generated
	 */
	EClass getLEMG1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMH1 <em>LEMH1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMH1</em>'.
	 * @see ca.mcgill.sel.language1.LEMH1
	 * @generated
	 */
	EClass getLEMH1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMI1 <em>LEMI1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMI1</em>'.
	 * @see ca.mcgill.sel.language1.LEMI1
	 * @generated
	 */
	EClass getLEMI1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMJ1 <em>LEMJ1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMJ1</em>'.
	 * @see ca.mcgill.sel.language1.LEMJ1
	 * @generated
	 */
	EClass getLEMJ1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEMK1 <em>LEMK1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMK1</em>'.
	 * @see ca.mcgill.sel.language1.LEMK1
	 * @generated
	 */
	EClass getLEMK1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.LEML1 <em>LEML1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEML1</em>'.
	 * @see ca.mcgill.sel.language1.LEML1
	 * @generated
	 */
	EClass getLEML1();

	/**
	 * Returns the meta object for class '{@link ca.mcgill.sel.language1.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see ca.mcgill.sel.language1.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcgill.sel.language1.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.mcgill.sel.language1.NamedElement#getName()
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
	Language1Factory getLanguage1Factory();

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
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.Language1Impl <em>Language1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.Language1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLanguage1()
		 * @generated
		 */
		EClass LANGUAGE1 = eINSTANCE.getLanguage1();

		/**
		 * The meta object literal for the '<em><b>Lema1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMA1S = eINSTANCE.getLanguage1_Lema1s();

		/**
		 * The meta object literal for the '<em><b>Lemb1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMB1S = eINSTANCE.getLanguage1_Lemb1s();

		/**
		 * The meta object literal for the '<em><b>Leme1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEME1S = eINSTANCE.getLanguage1_Leme1s();

		/**
		 * The meta object literal for the '<em><b>Lemc1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMC1S = eINSTANCE.getLanguage1_Lemc1s();

		/**
		 * The meta object literal for the '<em><b>Leml1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEML1S = eINSTANCE.getLanguage1_Leml1s();

		/**
		 * The meta object literal for the '<em><b>Lemf1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMF1S = eINSTANCE.getLanguage1_Lemf1s();

		/**
		 * The meta object literal for the '<em><b>Lemd1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMD1S = eINSTANCE.getLanguage1_Lemd1s();

		/**
		 * The meta object literal for the '<em><b>Lemg1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMG1S = eINSTANCE.getLanguage1_Lemg1s();

		/**
		 * The meta object literal for the '<em><b>Lemk1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMK1S = eINSTANCE.getLanguage1_Lemk1s();

		/**
		 * The meta object literal for the '<em><b>Lemj1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMJ1S = eINSTANCE.getLanguage1_Lemj1s();

		/**
		 * The meta object literal for the '<em><b>Lemi1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMI1S = eINSTANCE.getLanguage1_Lemi1s();

		/**
		 * The meta object literal for the '<em><b>Lemh1s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE1__LEMH1S = eINSTANCE.getLanguage1_Lemh1s();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMA1Impl <em>LEMA1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMA1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMA1()
		 * @generated
		 */
		EClass LEMA1 = eINSTANCE.getLEMA1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMB1Impl <em>LEMB1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMB1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMB1()
		 * @generated
		 */
		EClass LEMB1 = eINSTANCE.getLEMB1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMC1Impl <em>LEMC1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMC1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMC1()
		 * @generated
		 */
		EClass LEMC1 = eINSTANCE.getLEMC1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMD1Impl <em>LEMD1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMD1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMD1()
		 * @generated
		 */
		EClass LEMD1 = eINSTANCE.getLEMD1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEME1Impl <em>LEME1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEME1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEME1()
		 * @generated
		 */
		EClass LEME1 = eINSTANCE.getLEME1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMF1Impl <em>LEMF1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMF1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMF1()
		 * @generated
		 */
		EClass LEMF1 = eINSTANCE.getLEMF1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMG1Impl <em>LEMG1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMG1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMG1()
		 * @generated
		 */
		EClass LEMG1 = eINSTANCE.getLEMG1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMH1Impl <em>LEMH1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMH1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMH1()
		 * @generated
		 */
		EClass LEMH1 = eINSTANCE.getLEMH1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMI1Impl <em>LEMI1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMI1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMI1()
		 * @generated
		 */
		EClass LEMI1 = eINSTANCE.getLEMI1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMJ1Impl <em>LEMJ1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMJ1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMJ1()
		 * @generated
		 */
		EClass LEMJ1 = eINSTANCE.getLEMJ1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEMK1Impl <em>LEMK1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEMK1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEMK1()
		 * @generated
		 */
		EClass LEMK1 = eINSTANCE.getLEMK1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.LEML1Impl <em>LEML1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.LEML1Impl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getLEML1()
		 * @generated
		 */
		EClass LEML1 = eINSTANCE.getLEML1();

		/**
		 * The meta object literal for the '{@link ca.mcgill.sel.language1.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcgill.sel.language1.impl.NamedElementImpl
		 * @see ca.mcgill.sel.language1.impl.Language1PackageImpl#getNamedElement()
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

} //Language1Package
