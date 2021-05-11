/**
 */
package ca.mcgill.sel.cmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcgill.sel.cmodel.CModel#getC1s <em>C1s</em>}</li>
 *   <li>{@link ca.mcgill.sel.cmodel.CModel#getC2s <em>C2s</em>}</li>
 *   <li>{@link ca.mcgill.sel.cmodel.CModel#getC3s <em>C3s</em>}</li>
 *   <li>{@link ca.mcgill.sel.cmodel.CModel#getC4s <em>C4s</em>}</li>
 * </ul>
 *
 * @see ca.mcgill.sel.cmodel.CmodelPackage#getCModel()
 * @model
 * @generated
 */
public interface CModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>C1s</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcgill.sel.cmodel.C1}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C1s</em>' containment reference list.
	 * @see ca.mcgill.sel.cmodel.CmodelPackage#getCModel_C1s()
	 * @model containment="true"
	 * @generated
	 */
	EList<C1> getC1s();

	/**
	 * Returns the value of the '<em><b>C2s</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcgill.sel.cmodel.C2}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C2s</em>' containment reference list.
	 * @see ca.mcgill.sel.cmodel.CmodelPackage#getCModel_C2s()
	 * @model containment="true"
	 * @generated
	 */
	EList<C2> getC2s();

	/**
	 * Returns the value of the '<em><b>C3s</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcgill.sel.cmodel.C3}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C3s</em>' containment reference list.
	 * @see ca.mcgill.sel.cmodel.CmodelPackage#getCModel_C3s()
	 * @model containment="true"
	 * @generated
	 */
	EList<C3> getC3s();

	/**
	 * Returns the value of the '<em><b>C4s</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcgill.sel.cmodel.C4}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C4s</em>' containment reference list.
	 * @see ca.mcgill.sel.cmodel.CmodelPackage#getCModel_C4s()
	 * @model containment="true"
	 * @generated
	 */
	EList<C4> getC4s();

} // CModel
