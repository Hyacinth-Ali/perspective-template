/**
 */
package language1.impl;

import language1.Language1;
import language1.Language1Factory;
import language1.Language1Package;
import language1.NameElement;

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
public class Language1PackageImpl extends EPackageImpl implements Language1Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass language1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lema1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemb1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemc1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemd1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leme1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemf1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemg1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemh1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemi1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemj1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lemk1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leml1EClass = null;

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
	 * @see language1.Language1Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Language1PackageImpl() {
		super(eNS_URI, Language1Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Language1Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Language1Package init() {
		if (isInited) return (Language1Package)EPackage.Registry.INSTANCE.getEPackage(Language1Package.eNS_URI);

		// Obtain or create and register package
		Object registeredLanguage1Package = EPackage.Registry.INSTANCE.get(eNS_URI);
		Language1PackageImpl theLanguage1Package = registeredLanguage1Package instanceof Language1PackageImpl ? (Language1PackageImpl)registeredLanguage1Package : new Language1PackageImpl();

		isInited = true;

		// Create package meta-data objects
		theLanguage1Package.createPackageContents();

		// Initialize created meta-data
		theLanguage1Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLanguage1Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Language1Package.eNS_URI, theLanguage1Package);
		return theLanguage1Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguage1() {
		return language1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lema1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemb1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Leme1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemc1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Leml1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemf1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemd1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemg1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemk1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemj1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemi1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguage1_Lemh1s() {
		return (EReference)language1EClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMA1() {
		return lema1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMB1() {
		return lemb1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMC1() {
		return lemc1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMD1() {
		return lemd1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEME1() {
		return leme1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMF1() {
		return lemf1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMG1() {
		return lemg1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMH1() {
		return lemh1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMI1() {
		return lemi1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMJ1() {
		return lemj1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEMK1() {
		return lemk1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLEML1() {
		return leml1EClass;
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
	public Language1Factory getLanguage1Factory() {
		return (Language1Factory)getEFactoryInstance();
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
		language1EClass = createEClass(LANGUAGE1);
		createEReference(language1EClass, LANGUAGE1__LEMA1S);
		createEReference(language1EClass, LANGUAGE1__LEMB1S);
		createEReference(language1EClass, LANGUAGE1__LEME1S);
		createEReference(language1EClass, LANGUAGE1__LEMC1S);
		createEReference(language1EClass, LANGUAGE1__LEML1S);
		createEReference(language1EClass, LANGUAGE1__LEMF1S);
		createEReference(language1EClass, LANGUAGE1__LEMD1S);
		createEReference(language1EClass, LANGUAGE1__LEMG1S);
		createEReference(language1EClass, LANGUAGE1__LEMK1S);
		createEReference(language1EClass, LANGUAGE1__LEMJ1S);
		createEReference(language1EClass, LANGUAGE1__LEMI1S);
		createEReference(language1EClass, LANGUAGE1__LEMH1S);

		lema1EClass = createEClass(LEMA1);

		lemb1EClass = createEClass(LEMB1);

		lemc1EClass = createEClass(LEMC1);

		lemd1EClass = createEClass(LEMD1);

		leme1EClass = createEClass(LEME1);

		lemf1EClass = createEClass(LEMF1);

		lemg1EClass = createEClass(LEMG1);

		lemh1EClass = createEClass(LEMH1);

		lemi1EClass = createEClass(LEMI1);

		lemj1EClass = createEClass(LEMJ1);

		lemk1EClass = createEClass(LEMK1);

		leml1EClass = createEClass(LEML1);

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
		language1EClass.getESuperTypes().add(this.getNameElement());
		lema1EClass.getESuperTypes().add(this.getNameElement());
		lemb1EClass.getESuperTypes().add(this.getNameElement());
		lemc1EClass.getESuperTypes().add(this.getNameElement());
		lemd1EClass.getESuperTypes().add(this.getNameElement());
		leme1EClass.getESuperTypes().add(this.getNameElement());
		lemf1EClass.getESuperTypes().add(this.getNameElement());
		lemg1EClass.getESuperTypes().add(this.getNameElement());
		lemh1EClass.getESuperTypes().add(this.getNameElement());
		lemi1EClass.getESuperTypes().add(this.getNameElement());
		lemj1EClass.getESuperTypes().add(this.getNameElement());
		lemk1EClass.getESuperTypes().add(this.getNameElement());
		leml1EClass.getESuperTypes().add(this.getNameElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(language1EClass, Language1.class, "Language1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLanguage1_Lema1s(), this.getLEMA1(), null, "lema1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemb1s(), this.getLEMB1(), null, "lemb1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Leme1s(), this.getLEME1(), null, "leme1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemc1s(), this.getLEMC1(), null, "lemc1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Leml1s(), this.getLEML1(), null, "leml1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemf1s(), this.getLEMF1(), null, "lemf1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemd1s(), this.getLEMD1(), null, "lemd1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemg1s(), this.getLEMG1(), null, "lemg1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemk1s(), this.getLEMK1(), null, "lemk1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemj1s(), this.getLEMJ1(), null, "lemj1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemi1s(), this.getLEMI1(), null, "lemi1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguage1_Lemh1s(), this.getLEMH1(), null, "lemh1s", null, 0, -1, Language1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lema1EClass, language1.LEMA1.class, "LEMA1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemb1EClass, language1.LEMB1.class, "LEMB1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemc1EClass, language1.LEMC1.class, "LEMC1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemd1EClass, language1.LEMD1.class, "LEMD1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(leme1EClass, language1.LEME1.class, "LEME1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemf1EClass, language1.LEMF1.class, "LEMF1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemg1EClass, language1.LEMG1.class, "LEMG1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemh1EClass, language1.LEMH1.class, "LEMH1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemi1EClass, language1.LEMI1.class, "LEMI1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemj1EClass, language1.LEMJ1.class, "LEMJ1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lemk1EClass, language1.LEMK1.class, "LEMK1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(leml1EClass, language1.LEML1.class, "LEML1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameElementEClass, NameElement.class, "NameElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NameElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Language1PackageImpl
