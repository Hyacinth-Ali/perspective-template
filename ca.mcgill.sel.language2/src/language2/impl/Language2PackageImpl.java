/**
 */
package language2.impl;

import language2.Language2;
import language2.Language2Factory;
import language2.Language2Package;
import language2.NameElement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Language2PackageImpl extends EPackageImpl implements Language2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass language2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lema2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemb2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemc2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemd2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leme2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemf2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemg2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemh2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemi2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemj2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemk2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leml2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameElementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see language2.Language2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Language2PackageImpl() {
		super(eNS_URI, Language2Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Language2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Language2Package init() {
		if (isInited) return (Language2Package)EPackage.Registry.INSTANCE.getEPackage(Language2Package.eNS_URI);

		// Obtain or create and register package
		Object registeredLanguage2Package = EPackage.Registry.INSTANCE.get(eNS_URI);
		Language2PackageImpl theLanguage2Package = registeredLanguage2Package instanceof Language2PackageImpl ? (Language2PackageImpl)registeredLanguage2Package : new Language2PackageImpl();

		isInited = true;

		// Create package meta-data objects
		theLanguage2Package.createPackageContents();

		// Initialize created meta-data
		theLanguage2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLanguage2Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Language2Package.eNS_URI, theLanguage2Package);
		return theLanguage2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguage2() {
		return language2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lema2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemb2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Leme2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemc2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Leml2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemf2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemd2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemg2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemk2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemj2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemi2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage2_Lemh2s() {
		return (EReference)language2EClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMA2() {
		return lema2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMB2() {
		return lemb2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMC2() {
		return lemc2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMD2() {
		return lemd2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEME2() {
		return leme2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMF2() {
		return lemf2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMG2() {
		return lemg2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMH2() {
		return lemh2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMI2() {
		return lemi2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMJ2() {
		return lemj2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMK2() {
		return lemk2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEML2() {
		return leml2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameElement() {
		return nameElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameElement_Name() {
		return (EAttribute)nameElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language2Factory getLanguage2Factory() {
		return (Language2Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		language2EClass = createEClass(LANGUAGE2);
		createEReference(language2EClass, LANGUAGE2__LEMA2S);
		createEReference(language2EClass, LANGUAGE2__LEMB2S);
		createEReference(language2EClass, LANGUAGE2__LEME2S);
		createEReference(language2EClass, LANGUAGE2__LEMC2S);
		createEReference(language2EClass, LANGUAGE2__LEML2S);
		createEReference(language2EClass, LANGUAGE2__LEMF2S);
		createEReference(language2EClass, LANGUAGE2__LEMD2S);
		createEReference(language2EClass, LANGUAGE2__LEMG2S);
		createEReference(language2EClass, LANGUAGE2__LEMK2S);
		createEReference(language2EClass, LANGUAGE2__LEMJ2S);
		createEReference(language2EClass, LANGUAGE2__LEMI2S);
		createEReference(language2EClass, LANGUAGE2__LEMH2S);

		lema2EClass = createEClass(LEMA2);

		lemb2EClass = createEClass(LEMB2);

		lemc2EClass = createEClass(LEMC2);

		lemd2EClass = createEClass(LEMD2);

		leme2EClass = createEClass(LEME2);

		lemf2EClass = createEClass(LEMF2);

		lemg2EClass = createEClass(LEMG2);

		lemh2EClass = createEClass(LEMH2);

		lemi2EClass = createEClass(LEMI2);

		lemj2EClass = createEClass(LEMJ2);

		lemk2EClass = createEClass(LEMK2);

		leml2EClass = createEClass(LEML2);

		nameElementEClass = createEClass(NAME_ELEMENT);
		createEAttribute(nameElementEClass, NAME_ELEMENT__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		language2EClass.getESuperTypes().add(this.getNameElement());
		lema2EClass.getESuperTypes().add(this.getNameElement());
		lemb2EClass.getESuperTypes().add(this.getNameElement());
		lemc2EClass.getESuperTypes().add(this.getNameElement());
		lemd2EClass.getESuperTypes().add(this.getNameElement());
		leme2EClass.getESuperTypes().add(this.getNameElement());
		lemf2EClass.getESuperTypes().add(this.getNameElement());
		lemg2EClass.getESuperTypes().add(this.getNameElement());
		lemh2EClass.getESuperTypes().add(this.getNameElement());
		lemi2EClass.getESuperTypes().add(this.getNameElement());
		lemj2EClass.getESuperTypes().add(this.getNameElement());
		lemk2EClass.getESuperTypes().add(this.getNameElement());
		leml2EClass.getESuperTypes().add(this.getNameElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(language2EClass, Language2.class, "Language2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLanguage2_Lema2s(), this.getLEMA2(), null, "lema2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemb2s(), this.getLEMB2(), null, "lemb2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Leme2s(), this.getLEME2(), null, "leme2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemc2s(), this.getLEMC2(), null, "lemc2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Leml2s(), this.getLEML2(), null, "leml2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemf2s(), this.getLEMF2(), null, "lemf2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemd2s(), this.getLEMD2(), null, "lemd2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemg2s(), this.getLEMG2(), null, "lemg2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemk2s(), this.getLEMK2(), null, "lemk2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemj2s(), this.getLEMJ2(), null, "lemj2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemi2s(), this.getLEMI2(), null, "lemi2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage2_Lemh2s(), this.getLEMH2(), null, "lemh2s", null, 0, -1, Language2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lema2EClass, language2.LEMA2.class, "LEMA2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemb2EClass, language2.LEMB2.class, "LEMB2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemc2EClass, language2.LEMC2.class, "LEMC2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemd2EClass, language2.LEMD2.class, "LEMD2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(leme2EClass, language2.LEME2.class, "LEME2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemf2EClass, language2.LEMF2.class, "LEMF2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemg2EClass, language2.LEMG2.class, "LEMG2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemh2EClass, language2.LEMH2.class, "LEMH2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemi2EClass, language2.LEMI2.class, "LEMI2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemj2EClass, language2.LEMJ2.class, "LEMJ2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemk2EClass, language2.LEMK2.class, "LEMK2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(leml2EClass, language2.LEML2.class, "LEML2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameElementEClass, NameElement.class, "NameElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NameElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Language2PackageImpl
