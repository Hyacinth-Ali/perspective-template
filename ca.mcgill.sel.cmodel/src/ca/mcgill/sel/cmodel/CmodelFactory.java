/**
 */
package ca.mcgill.sel.cmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.mcgill.sel.cmodel.CmodelPackage
 * @generated
 */
public interface CmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CmodelFactory eINSTANCE = ca.mcgill.sel.cmodel.impl.CmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CModel</em>'.
	 * @generated
	 */
	CModel createCModel();

	/**
	 * Returns a new object of class '<em>C1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>C1</em>'.
	 * @generated
	 */
	C1 createC1();

	/**
	 * Returns a new object of class '<em>C2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>C2</em>'.
	 * @generated
	 */
	C2 createC2();

	/**
	 * Returns a new object of class '<em>C3</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>C3</em>'.
	 * @generated
	 */
	C3 createC3();

	/**
	 * Returns a new object of class '<em>C4</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>C4</em>'.
	 * @generated
	 */
	C4 createC4();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CmodelPackage getCmodelPackage();

} //CmodelFactory
