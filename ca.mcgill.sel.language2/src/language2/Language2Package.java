/**
 */
package language2;

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
 * @see language2.Language2Factory
 * @model kind="package"
 * @generated
 */
public interface Language2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "language2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "language2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "language2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Language2Package eINSTANCE = language2.impl.Language2PackageImpl.init();

	/**
	 * The meta object id for the '{@link language2.impl.NameElementImpl <em>Name Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.NameElementImpl
	 * @see language2.impl.Language2PackageImpl#getNameElement()
	 * @generated
	 */
	int NAME_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Name Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Name Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link language2.impl.Language2Impl <em>Language2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.Language2Impl
	 * @see language2.impl.Language2PackageImpl#getLanguage2()
	 * @generated
	 */
	int LANGUAGE2 = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Lema2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMA2S = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lemb2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMB2S = NAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Leme2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEME2S = NAME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lemc2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMC2S = NAME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Leml2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEML2S = NAME_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Lemf2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMF2S = NAME_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Lemd2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMD2S = NAME_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Lemg2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMG2S = NAME_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Lemk2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMK2S = NAME_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Lemj2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMJ2S = NAME_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Lemi2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMI2S = NAME_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Lemh2s</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2__LEMH2S = NAME_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Language2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Language2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMA2Impl <em>LEMA2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMA2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMA2()
	 * @generated
	 */
	int LEMA2 = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMA2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMA2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMA2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMA2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMA2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMB2Impl <em>LEMB2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMB2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMB2()
	 * @generated
	 */
	int LEMB2 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMB2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMB2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMB2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMB2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMB2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMC2Impl <em>LEMC2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMC2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMC2()
	 * @generated
	 */
	int LEMC2 = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMC2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMC2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMC2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMC2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMC2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMD2Impl <em>LEMD2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMD2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMD2()
	 * @generated
	 */
	int LEMD2 = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMD2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMD2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMD2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMD2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMD2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEME2Impl <em>LEME2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEME2Impl
	 * @see language2.impl.Language2PackageImpl#getLEME2()
	 * @generated
	 */
	int LEME2 = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEME2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEME2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEME2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEME2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEME2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMF2Impl <em>LEMF2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMF2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMF2()
	 * @generated
	 */
	int LEMF2 = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMF2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMF2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMF2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMF2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMF2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMG2Impl <em>LEMG2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMG2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMG2()
	 * @generated
	 */
	int LEMG2 = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMG2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMG2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMG2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMG2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMG2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMH2Impl <em>LEMH2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMH2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMH2()
	 * @generated
	 */
	int LEMH2 = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMH2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMH2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMH2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMH2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMH2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMI2Impl <em>LEMI2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMI2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMI2()
	 * @generated
	 */
	int LEMI2 = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMI2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMI2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMI2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMI2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMI2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMJ2Impl <em>LEMJ2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMJ2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMJ2()
	 * @generated
	 */
	int LEMJ2 = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMJ2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMJ2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMJ2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMJ2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMJ2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEMK2Impl <em>LEMK2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEMK2Impl
	 * @see language2.impl.Language2PackageImpl#getLEMK2()
	 * @generated
	 */
	int LEMK2 = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMK2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEMK2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMK2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEMK2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMK2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link language2.impl.LEML2Impl <em>LEML2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see language2.impl.LEML2Impl
	 * @see language2.impl.Language2PackageImpl#getLEML2()
	 * @generated
	 */
	int LEML2 = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEML2__NAME = NAME_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>LEML2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEML2_FEATURE_COUNT = NAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>LEML2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEML2_OPERATION_COUNT = NAME_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link language2.Language2 <em>Language2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language2</em>'.
	 * @see language2.Language2
	 * @generated
	 */
	EClass getLanguage2();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLema2s <em>Lema2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lema2s</em>'.
	 * @see language2.Language2#getLema2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lema2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemb2s <em>Lemb2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemb2s</em>'.
	 * @see language2.Language2#getLemb2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemb2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLeme2s <em>Leme2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leme2s</em>'.
	 * @see language2.Language2#getLeme2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Leme2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemc2s <em>Lemc2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemc2s</em>'.
	 * @see language2.Language2#getLemc2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemc2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLeml2s <em>Leml2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leml2s</em>'.
	 * @see language2.Language2#getLeml2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Leml2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemf2s <em>Lemf2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemf2s</em>'.
	 * @see language2.Language2#getLemf2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemf2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemd2s <em>Lemd2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemd2s</em>'.
	 * @see language2.Language2#getLemd2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemd2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemg2s <em>Lemg2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemg2s</em>'.
	 * @see language2.Language2#getLemg2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemg2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemk2s <em>Lemk2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemk2s</em>'.
	 * @see language2.Language2#getLemk2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemk2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemj2s <em>Lemj2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemj2s</em>'.
	 * @see language2.Language2#getLemj2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemj2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemi2s <em>Lemi2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemi2s</em>'.
	 * @see language2.Language2#getLemi2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemi2s();

	/**
	 * Returns the meta object for the containment reference list '{@link language2.Language2#getLemh2s <em>Lemh2s</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lemh2s</em>'.
	 * @see language2.Language2#getLemh2s()
	 * @see #getLanguage2()
	 * @generated
	 */
	EReference getLanguage2_Lemh2s();

	/**
	 * Returns the meta object for class '{@link language2.LEMA2 <em>LEMA2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMA2</em>'.
	 * @see language2.LEMA2
	 * @generated
	 */
	EClass getLEMA2();

	/**
	 * Returns the meta object for class '{@link language2.LEMB2 <em>LEMB2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMB2</em>'.
	 * @see language2.LEMB2
	 * @generated
	 */
	EClass getLEMB2();

	/**
	 * Returns the meta object for class '{@link language2.LEMC2 <em>LEMC2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMC2</em>'.
	 * @see language2.LEMC2
	 * @generated
	 */
	EClass getLEMC2();

	/**
	 * Returns the meta object for class '{@link language2.LEMD2 <em>LEMD2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMD2</em>'.
	 * @see language2.LEMD2
	 * @generated
	 */
	EClass getLEMD2();

	/**
	 * Returns the meta object for class '{@link language2.LEME2 <em>LEME2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEME2</em>'.
	 * @see language2.LEME2
	 * @generated
	 */
	EClass getLEME2();

	/**
	 * Returns the meta object for class '{@link language2.LEMF2 <em>LEMF2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMF2</em>'.
	 * @see language2.LEMF2
	 * @generated
	 */
	EClass getLEMF2();

	/**
	 * Returns the meta object for class '{@link language2.LEMG2 <em>LEMG2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMG2</em>'.
	 * @see language2.LEMG2
	 * @generated
	 */
	EClass getLEMG2();

	/**
	 * Returns the meta object for class '{@link language2.LEMH2 <em>LEMH2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMH2</em>'.
	 * @see language2.LEMH2
	 * @generated
	 */
	EClass getLEMH2();

	/**
	 * Returns the meta object for class '{@link language2.LEMI2 <em>LEMI2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMI2</em>'.
	 * @see language2.LEMI2
	 * @generated
	 */
	EClass getLEMI2();

	/**
	 * Returns the meta object for class '{@link language2.LEMJ2 <em>LEMJ2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMJ2</em>'.
	 * @see language2.LEMJ2
	 * @generated
	 */
	EClass getLEMJ2();

	/**
	 * Returns the meta object for class '{@link language2.LEMK2 <em>LEMK2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEMK2</em>'.
	 * @see language2.LEMK2
	 * @generated
	 */
	EClass getLEMK2();

	/**
	 * Returns the meta object for class '{@link language2.LEML2 <em>LEML2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LEML2</em>'.
	 * @see language2.LEML2
	 * @generated
	 */
	EClass getLEML2();

	/**
	 * Returns the meta object for class '{@link language2.NameElement <em>Name Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Element</em>'.
	 * @see language2.NameElement
	 * @generated
	 */
	EClass getNameElement();

	/**
	 * Returns the meta object for the attribute '{@link language2.NameElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see language2.NameElement#getName()
	 * @see #getNameElement()
	 * @generated
	 */
	EAttribute getNameElement_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Language2Factory getLanguage2Factory();

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
		 * The meta object literal for the '{@link language2.impl.Language2Impl <em>Language2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.Language2Impl
		 * @see language2.impl.Language2PackageImpl#getLanguage2()
		 * @generated
		 */
		EClass LANGUAGE2 = eINSTANCE.getLanguage2();

		/**
		 * The meta object literal for the '<em><b>Lema2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMA2S = eINSTANCE.getLanguage2_Lema2s();

		/**
		 * The meta object literal for the '<em><b>Lemb2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMB2S = eINSTANCE.getLanguage2_Lemb2s();

		/**
		 * The meta object literal for the '<em><b>Leme2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEME2S = eINSTANCE.getLanguage2_Leme2s();

		/**
		 * The meta object literal for the '<em><b>Lemc2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMC2S = eINSTANCE.getLanguage2_Lemc2s();

		/**
		 * The meta object literal for the '<em><b>Leml2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEML2S = eINSTANCE.getLanguage2_Leml2s();

		/**
		 * The meta object literal for the '<em><b>Lemf2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMF2S = eINSTANCE.getLanguage2_Lemf2s();

		/**
		 * The meta object literal for the '<em><b>Lemd2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMD2S = eINSTANCE.getLanguage2_Lemd2s();

		/**
		 * The meta object literal for the '<em><b>Lemg2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMG2S = eINSTANCE.getLanguage2_Lemg2s();

		/**
		 * The meta object literal for the '<em><b>Lemk2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMK2S = eINSTANCE.getLanguage2_Lemk2s();

		/**
		 * The meta object literal for the '<em><b>Lemj2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMJ2S = eINSTANCE.getLanguage2_Lemj2s();

		/**
		 * The meta object literal for the '<em><b>Lemi2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMI2S = eINSTANCE.getLanguage2_Lemi2s();

		/**
		 * The meta object literal for the '<em><b>Lemh2s</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE2__LEMH2S = eINSTANCE.getLanguage2_Lemh2s();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMA2Impl <em>LEMA2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMA2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMA2()
		 * @generated
		 */
		EClass LEMA2 = eINSTANCE.getLEMA2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMB2Impl <em>LEMB2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMB2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMB2()
		 * @generated
		 */
		EClass LEMB2 = eINSTANCE.getLEMB2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMC2Impl <em>LEMC2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMC2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMC2()
		 * @generated
		 */
		EClass LEMC2 = eINSTANCE.getLEMC2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMD2Impl <em>LEMD2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMD2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMD2()
		 * @generated
		 */
		EClass LEMD2 = eINSTANCE.getLEMD2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEME2Impl <em>LEME2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEME2Impl
		 * @see language2.impl.Language2PackageImpl#getLEME2()
		 * @generated
		 */
		EClass LEME2 = eINSTANCE.getLEME2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMF2Impl <em>LEMF2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMF2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMF2()
		 * @generated
		 */
		EClass LEMF2 = eINSTANCE.getLEMF2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMG2Impl <em>LEMG2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMG2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMG2()
		 * @generated
		 */
		EClass LEMG2 = eINSTANCE.getLEMG2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMH2Impl <em>LEMH2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMH2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMH2()
		 * @generated
		 */
		EClass LEMH2 = eINSTANCE.getLEMH2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMI2Impl <em>LEMI2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMI2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMI2()
		 * @generated
		 */
		EClass LEMI2 = eINSTANCE.getLEMI2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMJ2Impl <em>LEMJ2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMJ2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMJ2()
		 * @generated
		 */
		EClass LEMJ2 = eINSTANCE.getLEMJ2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEMK2Impl <em>LEMK2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEMK2Impl
		 * @see language2.impl.Language2PackageImpl#getLEMK2()
		 * @generated
		 */
		EClass LEMK2 = eINSTANCE.getLEMK2();

		/**
		 * The meta object literal for the '{@link language2.impl.LEML2Impl <em>LEML2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.LEML2Impl
		 * @see language2.impl.Language2PackageImpl#getLEML2()
		 * @generated
		 */
		EClass LEML2 = eINSTANCE.getLEML2();

		/**
		 * The meta object literal for the '{@link language2.impl.NameElementImpl <em>Name Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see language2.impl.NameElementImpl
		 * @see language2.impl.Language2PackageImpl#getNameElement()
		 * @generated
		 */
		EClass NAME_ELEMENT = eINSTANCE.getNameElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_ELEMENT__NAME = eINSTANCE.getNameElement_Name();

	}

} //Language2Package
