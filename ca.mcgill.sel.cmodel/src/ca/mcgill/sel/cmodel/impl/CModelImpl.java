/**
 */
package ca.mcgill.sel.cmodel.impl;

import ca.mcgill.sel.cmodel.C1;
import ca.mcgill.sel.cmodel.C2;
import ca.mcgill.sel.cmodel.C3;
import ca.mcgill.sel.cmodel.C4;
import ca.mcgill.sel.cmodel.CModel;
import ca.mcgill.sel.cmodel.CmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.mcgill.sel.cmodel.impl.CModelImpl#getC1s <em>C1s</em>}</li>
 *   <li>{@link ca.mcgill.sel.cmodel.impl.CModelImpl#getC2s <em>C2s</em>}</li>
 *   <li>{@link ca.mcgill.sel.cmodel.impl.CModelImpl#getC3s <em>C3s</em>}</li>
 *   <li>{@link ca.mcgill.sel.cmodel.impl.CModelImpl#getC4s <em>C4s</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CModelImpl extends NamedElementImpl implements CModel {
	/**
	 * The cached value of the '{@link #getC1s() <em>C1s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC1s()
	 * @generated
	 * @ordered
	 */
	protected EList<C1> c1s;

	/**
	 * The cached value of the '{@link #getC2s() <em>C2s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC2s()
	 * @generated
	 * @ordered
	 */
	protected EList<C2> c2s;

	/**
	 * The cached value of the '{@link #getC3s() <em>C3s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC3s()
	 * @generated
	 * @ordered
	 */
	protected EList<C3> c3s;

	/**
	 * The cached value of the '{@link #getC4s() <em>C4s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC4s()
	 * @generated
	 * @ordered
	 */
	protected EList<C4> c4s;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CmodelPackage.Literals.CMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C1> getC1s() {
		if (c1s == null) {
			c1s = new EObjectContainmentEList<C1>(C1.class, this, CmodelPackage.CMODEL__C1S);
		}
		return c1s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C2> getC2s() {
		if (c2s == null) {
			c2s = new EObjectContainmentEList<C2>(C2.class, this, CmodelPackage.CMODEL__C2S);
		}
		return c2s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C3> getC3s() {
		if (c3s == null) {
			c3s = new EObjectContainmentEList<C3>(C3.class, this, CmodelPackage.CMODEL__C3S);
		}
		return c3s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C4> getC4s() {
		if (c4s == null) {
			c4s = new EObjectContainmentEList<C4>(C4.class, this, CmodelPackage.CMODEL__C4S);
		}
		return c4s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CmodelPackage.CMODEL__C1S:
				return ((InternalEList<?>)getC1s()).basicRemove(otherEnd, msgs);
			case CmodelPackage.CMODEL__C2S:
				return ((InternalEList<?>)getC2s()).basicRemove(otherEnd, msgs);
			case CmodelPackage.CMODEL__C3S:
				return ((InternalEList<?>)getC3s()).basicRemove(otherEnd, msgs);
			case CmodelPackage.CMODEL__C4S:
				return ((InternalEList<?>)getC4s()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CmodelPackage.CMODEL__C1S:
				return getC1s();
			case CmodelPackage.CMODEL__C2S:
				return getC2s();
			case CmodelPackage.CMODEL__C3S:
				return getC3s();
			case CmodelPackage.CMODEL__C4S:
				return getC4s();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CmodelPackage.CMODEL__C1S:
				getC1s().clear();
				getC1s().addAll((Collection<? extends C1>)newValue);
				return;
			case CmodelPackage.CMODEL__C2S:
				getC2s().clear();
				getC2s().addAll((Collection<? extends C2>)newValue);
				return;
			case CmodelPackage.CMODEL__C3S:
				getC3s().clear();
				getC3s().addAll((Collection<? extends C3>)newValue);
				return;
			case CmodelPackage.CMODEL__C4S:
				getC4s().clear();
				getC4s().addAll((Collection<? extends C4>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CmodelPackage.CMODEL__C1S:
				getC1s().clear();
				return;
			case CmodelPackage.CMODEL__C2S:
				getC2s().clear();
				return;
			case CmodelPackage.CMODEL__C3S:
				getC3s().clear();
				return;
			case CmodelPackage.CMODEL__C4S:
				getC4s().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CmodelPackage.CMODEL__C1S:
				return c1s != null && !c1s.isEmpty();
			case CmodelPackage.CMODEL__C2S:
				return c2s != null && !c2s.isEmpty();
			case CmodelPackage.CMODEL__C3S:
				return c3s != null && !c3s.isEmpty();
			case CmodelPackage.CMODEL__C4S:
				return c4s != null && !c4s.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CModelImpl
