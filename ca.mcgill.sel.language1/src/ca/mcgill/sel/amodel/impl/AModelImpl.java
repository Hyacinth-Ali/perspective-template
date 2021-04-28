/**
 */
package ca.mcgill.sel.amodel.impl;

import ca.mcgill.sel.amodel.A1;
import ca.mcgill.sel.amodel.A10;
import ca.mcgill.sel.amodel.A11;
import ca.mcgill.sel.amodel.A12;
import ca.mcgill.sel.amodel.A2;
import ca.mcgill.sel.amodel.A3;
import ca.mcgill.sel.amodel.A4;
import ca.mcgill.sel.amodel.A5;
import ca.mcgill.sel.amodel.A6;
import ca.mcgill.sel.amodel.A7;
import ca.mcgill.sel.amodel.A8;
import ca.mcgill.sel.amodel.A9;
import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.AmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA1s <em>A1s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA2s <em>A2s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA5s <em>A5s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA3s <em>A3s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA12s <em>A1 2s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA6s <em>A6s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA4s <em>A4s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA7s <em>A7s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA11s <em>A1 1s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA10s <em>A1 0s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA9s <em>A9s</em>}</li>
 *   <li>{@link ca.mcgill.sel.amodel.impl.AModelImpl#getA8s <em>A8s</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AModelImpl extends NamedElementImpl implements AModel {
	/**
	 * The cached value of the '{@link #getA1s() <em>A1s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA1s()
	 * @generated
	 * @ordered
	 */
	protected EList<A1> a1s;

	/**
	 * The cached value of the '{@link #getA2s() <em>A2s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA2s()
	 * @generated
	 * @ordered
	 */
	protected EList<A2> a2s;

	/**
	 * The cached value of the '{@link #getA5s() <em>A5s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA5s()
	 * @generated
	 * @ordered
	 */
	protected EList<A5> a5s;

	/**
	 * The cached value of the '{@link #getA3s() <em>A3s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA3s()
	 * @generated
	 * @ordered
	 */
	protected EList<A3> a3s;

	/**
	 * The cached value of the '{@link #getA12s() <em>A1 2s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA12s()
	 * @generated
	 * @ordered
	 */
	protected EList<A12> a12s;

	/**
	 * The cached value of the '{@link #getA6s() <em>A6s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA6s()
	 * @generated
	 * @ordered
	 */
	protected EList<A6> a6s;

	/**
	 * The cached value of the '{@link #getA4s() <em>A4s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA4s()
	 * @generated
	 * @ordered
	 */
	protected EList<A4> a4s;

	/**
	 * The cached value of the '{@link #getA7s() <em>A7s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA7s()
	 * @generated
	 * @ordered
	 */
	protected EList<A7> a7s;

	/**
	 * The cached value of the '{@link #getA11s() <em>A1 1s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA11s()
	 * @generated
	 * @ordered
	 */
	protected EList<A11> a11s;

	/**
	 * The cached value of the '{@link #getA10s() <em>A1 0s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA10s()
	 * @generated
	 * @ordered
	 */
	protected EList<A10> a10s;

	/**
	 * The cached value of the '{@link #getA9s() <em>A9s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA9s()
	 * @generated
	 * @ordered
	 */
	protected EList<A9> a9s;

	/**
	 * The cached value of the '{@link #getA8s() <em>A8s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA8s()
	 * @generated
	 * @ordered
	 */
	protected EList<A8> a8s;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AmodelPackage.Literals.AMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A1> getA1s() {
		if (a1s == null) {
			a1s = new EObjectContainmentEList<A1>(A1.class, this, AmodelPackage.AMODEL__A1S);
		}
		return a1s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A2> getA2s() {
		if (a2s == null) {
			a2s = new EObjectContainmentEList<A2>(A2.class, this, AmodelPackage.AMODEL__A2S);
		}
		return a2s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A5> getA5s() {
		if (a5s == null) {
			a5s = new EObjectContainmentEList<A5>(A5.class, this, AmodelPackage.AMODEL__A5S);
		}
		return a5s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A3> getA3s() {
		if (a3s == null) {
			a3s = new EObjectContainmentEList<A3>(A3.class, this, AmodelPackage.AMODEL__A3S);
		}
		return a3s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A12> getA12s() {
		if (a12s == null) {
			a12s = new EObjectContainmentEList<A12>(A12.class, this, AmodelPackage.AMODEL__A12S);
		}
		return a12s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A6> getA6s() {
		if (a6s == null) {
			a6s = new EObjectContainmentEList<A6>(A6.class, this, AmodelPackage.AMODEL__A6S);
		}
		return a6s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A4> getA4s() {
		if (a4s == null) {
			a4s = new EObjectContainmentEList<A4>(A4.class, this, AmodelPackage.AMODEL__A4S);
		}
		return a4s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A7> getA7s() {
		if (a7s == null) {
			a7s = new EObjectContainmentEList<A7>(A7.class, this, AmodelPackage.AMODEL__A7S);
		}
		return a7s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A11> getA11s() {
		if (a11s == null) {
			a11s = new EObjectContainmentEList<A11>(A11.class, this, AmodelPackage.AMODEL__A11S);
		}
		return a11s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A10> getA10s() {
		if (a10s == null) {
			a10s = new EObjectContainmentEList<A10>(A10.class, this, AmodelPackage.AMODEL__A10S);
		}
		return a10s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A9> getA9s() {
		if (a9s == null) {
			a9s = new EObjectContainmentEList<A9>(A9.class, this, AmodelPackage.AMODEL__A9S);
		}
		return a9s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A8> getA8s() {
		if (a8s == null) {
			a8s = new EObjectContainmentEList<A8>(A8.class, this, AmodelPackage.AMODEL__A8S);
		}
		return a8s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AmodelPackage.AMODEL__A1S:
				return ((InternalEList<?>)getA1s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A2S:
				return ((InternalEList<?>)getA2s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A5S:
				return ((InternalEList<?>)getA5s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A3S:
				return ((InternalEList<?>)getA3s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A12S:
				return ((InternalEList<?>)getA12s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A6S:
				return ((InternalEList<?>)getA6s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A4S:
				return ((InternalEList<?>)getA4s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A7S:
				return ((InternalEList<?>)getA7s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A11S:
				return ((InternalEList<?>)getA11s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A10S:
				return ((InternalEList<?>)getA10s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A9S:
				return ((InternalEList<?>)getA9s()).basicRemove(otherEnd, msgs);
			case AmodelPackage.AMODEL__A8S:
				return ((InternalEList<?>)getA8s()).basicRemove(otherEnd, msgs);
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
			case AmodelPackage.AMODEL__A1S:
				return getA1s();
			case AmodelPackage.AMODEL__A2S:
				return getA2s();
			case AmodelPackage.AMODEL__A5S:
				return getA5s();
			case AmodelPackage.AMODEL__A3S:
				return getA3s();
			case AmodelPackage.AMODEL__A12S:
				return getA12s();
			case AmodelPackage.AMODEL__A6S:
				return getA6s();
			case AmodelPackage.AMODEL__A4S:
				return getA4s();
			case AmodelPackage.AMODEL__A7S:
				return getA7s();
			case AmodelPackage.AMODEL__A11S:
				return getA11s();
			case AmodelPackage.AMODEL__A10S:
				return getA10s();
			case AmodelPackage.AMODEL__A9S:
				return getA9s();
			case AmodelPackage.AMODEL__A8S:
				return getA8s();
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
			case AmodelPackage.AMODEL__A1S:
				getA1s().clear();
				getA1s().addAll((Collection<? extends A1>)newValue);
				return;
			case AmodelPackage.AMODEL__A2S:
				getA2s().clear();
				getA2s().addAll((Collection<? extends A2>)newValue);
				return;
			case AmodelPackage.AMODEL__A5S:
				getA5s().clear();
				getA5s().addAll((Collection<? extends A5>)newValue);
				return;
			case AmodelPackage.AMODEL__A3S:
				getA3s().clear();
				getA3s().addAll((Collection<? extends A3>)newValue);
				return;
			case AmodelPackage.AMODEL__A12S:
				getA12s().clear();
				getA12s().addAll((Collection<? extends A12>)newValue);
				return;
			case AmodelPackage.AMODEL__A6S:
				getA6s().clear();
				getA6s().addAll((Collection<? extends A6>)newValue);
				return;
			case AmodelPackage.AMODEL__A4S:
				getA4s().clear();
				getA4s().addAll((Collection<? extends A4>)newValue);
				return;
			case AmodelPackage.AMODEL__A7S:
				getA7s().clear();
				getA7s().addAll((Collection<? extends A7>)newValue);
				return;
			case AmodelPackage.AMODEL__A11S:
				getA11s().clear();
				getA11s().addAll((Collection<? extends A11>)newValue);
				return;
			case AmodelPackage.AMODEL__A10S:
				getA10s().clear();
				getA10s().addAll((Collection<? extends A10>)newValue);
				return;
			case AmodelPackage.AMODEL__A9S:
				getA9s().clear();
				getA9s().addAll((Collection<? extends A9>)newValue);
				return;
			case AmodelPackage.AMODEL__A8S:
				getA8s().clear();
				getA8s().addAll((Collection<? extends A8>)newValue);
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
			case AmodelPackage.AMODEL__A1S:
				getA1s().clear();
				return;
			case AmodelPackage.AMODEL__A2S:
				getA2s().clear();
				return;
			case AmodelPackage.AMODEL__A5S:
				getA5s().clear();
				return;
			case AmodelPackage.AMODEL__A3S:
				getA3s().clear();
				return;
			case AmodelPackage.AMODEL__A12S:
				getA12s().clear();
				return;
			case AmodelPackage.AMODEL__A6S:
				getA6s().clear();
				return;
			case AmodelPackage.AMODEL__A4S:
				getA4s().clear();
				return;
			case AmodelPackage.AMODEL__A7S:
				getA7s().clear();
				return;
			case AmodelPackage.AMODEL__A11S:
				getA11s().clear();
				return;
			case AmodelPackage.AMODEL__A10S:
				getA10s().clear();
				return;
			case AmodelPackage.AMODEL__A9S:
				getA9s().clear();
				return;
			case AmodelPackage.AMODEL__A8S:
				getA8s().clear();
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
			case AmodelPackage.AMODEL__A1S:
				return a1s != null && !a1s.isEmpty();
			case AmodelPackage.AMODEL__A2S:
				return a2s != null && !a2s.isEmpty();
			case AmodelPackage.AMODEL__A5S:
				return a5s != null && !a5s.isEmpty();
			case AmodelPackage.AMODEL__A3S:
				return a3s != null && !a3s.isEmpty();
			case AmodelPackage.AMODEL__A12S:
				return a12s != null && !a12s.isEmpty();
			case AmodelPackage.AMODEL__A6S:
				return a6s != null && !a6s.isEmpty();
			case AmodelPackage.AMODEL__A4S:
				return a4s != null && !a4s.isEmpty();
			case AmodelPackage.AMODEL__A7S:
				return a7s != null && !a7s.isEmpty();
			case AmodelPackage.AMODEL__A11S:
				return a11s != null && !a11s.isEmpty();
			case AmodelPackage.AMODEL__A10S:
				return a10s != null && !a10s.isEmpty();
			case AmodelPackage.AMODEL__A9S:
				return a9s != null && !a9s.isEmpty();
			case AmodelPackage.AMODEL__A8S:
				return a8s != null && !a8s.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AModelImpl
