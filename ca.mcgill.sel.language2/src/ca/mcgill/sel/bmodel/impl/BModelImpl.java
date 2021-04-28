/**
 */
package ca.mcgill.sel.bmodel.impl;

import ca.mcgill.sel.bmodel.B1;
import ca.mcgill.sel.bmodel.B10;
import ca.mcgill.sel.bmodel.B11;
import ca.mcgill.sel.bmodel.B12;
import ca.mcgill.sel.bmodel.B2;
import ca.mcgill.sel.bmodel.B3;
import ca.mcgill.sel.bmodel.B4;
import ca.mcgill.sel.bmodel.B5;
import ca.mcgill.sel.bmodel.B6;
import ca.mcgill.sel.bmodel.B7;
import ca.mcgill.sel.bmodel.B8;
import ca.mcgill.sel.bmodel.B9;
import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.BmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB1s <em>B1s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB2s <em>B2s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB5s <em>B5s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB3s <em>B3s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB12s <em>B1 2s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB6s <em>B6s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB4s <em>B4s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB7s <em>B7s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB11s <em>B1 1s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB10s <em>B1 0s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB9s <em>B9s</em>}</li>
 *   <li>{@link ca.mcgill.sel.bmodel.impl.BModelImpl#getB8s <em>B8s</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BModelImpl extends NamedElementImpl implements BModel {
	/**
	 * The cached value of the '{@link #getB1s() <em>B1s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB1s()
	 * @generated
	 * @ordered
	 */
	protected EList<B1> b1s;

	/**
	 * The cached value of the '{@link #getB2s() <em>B2s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB2s()
	 * @generated
	 * @ordered
	 */
	protected EList<B2> b2s;

	/**
	 * The cached value of the '{@link #getB5s() <em>B5s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB5s()
	 * @generated
	 * @ordered
	 */
	protected EList<B5> b5s;

	/**
	 * The cached value of the '{@link #getB3s() <em>B3s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB3s()
	 * @generated
	 * @ordered
	 */
	protected EList<B3> b3s;

	/**
	 * The cached value of the '{@link #getB12s() <em>B1 2s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB12s()
	 * @generated
	 * @ordered
	 */
	protected EList<B12> b12s;

	/**
	 * The cached value of the '{@link #getB6s() <em>B6s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB6s()
	 * @generated
	 * @ordered
	 */
	protected EList<B6> b6s;

	/**
	 * The cached value of the '{@link #getB4s() <em>B4s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB4s()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> b4s;

	/**
	 * The cached value of the '{@link #getB7s() <em>B7s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB7s()
	 * @generated
	 * @ordered
	 */
	protected EList<B7> b7s;

	/**
	 * The cached value of the '{@link #getB11s() <em>B1 1s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB11s()
	 * @generated
	 * @ordered
	 */
	protected EList<B11> b11s;

	/**
	 * The cached value of the '{@link #getB10s() <em>B1 0s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB10s()
	 * @generated
	 * @ordered
	 */
	protected EList<B10> b10s;

	/**
	 * The cached value of the '{@link #getB9s() <em>B9s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB9s()
	 * @generated
	 * @ordered
	 */
	protected EList<B9> b9s;

	/**
	 * The cached value of the '{@link #getB8s() <em>B8s</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB8s()
	 * @generated
	 * @ordered
	 */
	protected EList<B8> b8s;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BmodelPackage.Literals.BMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B1> getB1s() {
		if (b1s == null) {
			b1s = new EObjectContainmentEList<B1>(B1.class, this, BmodelPackage.BMODEL__B1S);
		}
		return b1s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B2> getB2s() {
		if (b2s == null) {
			b2s = new EObjectContainmentEList<B2>(B2.class, this, BmodelPackage.BMODEL__B2S);
		}
		return b2s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B5> getB5s() {
		if (b5s == null) {
			b5s = new EObjectContainmentEList<B5>(B5.class, this, BmodelPackage.BMODEL__B5S);
		}
		return b5s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B3> getB3s() {
		if (b3s == null) {
			b3s = new EObjectContainmentEList<B3>(B3.class, this, BmodelPackage.BMODEL__B3S);
		}
		return b3s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B12> getB12s() {
		if (b12s == null) {
			b12s = new EObjectContainmentEList<B12>(B12.class, this, BmodelPackage.BMODEL__B12S);
		}
		return b12s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B6> getB6s() {
		if (b6s == null) {
			b6s = new EObjectContainmentEList<B6>(B6.class, this, BmodelPackage.BMODEL__B6S);
		}
		return b6s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getB4s() {
		if (b4s == null) {
			b4s = new EObjectContainmentEList<B4>(B4.class, this, BmodelPackage.BMODEL__B4S);
		}
		return b4s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B7> getB7s() {
		if (b7s == null) {
			b7s = new EObjectContainmentEList<B7>(B7.class, this, BmodelPackage.BMODEL__B7S);
		}
		return b7s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B11> getB11s() {
		if (b11s == null) {
			b11s = new EObjectContainmentEList<B11>(B11.class, this, BmodelPackage.BMODEL__B11S);
		}
		return b11s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B10> getB10s() {
		if (b10s == null) {
			b10s = new EObjectContainmentEList<B10>(B10.class, this, BmodelPackage.BMODEL__B10S);
		}
		return b10s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B9> getB9s() {
		if (b9s == null) {
			b9s = new EObjectContainmentEList<B9>(B9.class, this, BmodelPackage.BMODEL__B9S);
		}
		return b9s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B8> getB8s() {
		if (b8s == null) {
			b8s = new EObjectContainmentEList<B8>(B8.class, this, BmodelPackage.BMODEL__B8S);
		}
		return b8s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BmodelPackage.BMODEL__B1S:
				return ((InternalEList<?>)getB1s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B2S:
				return ((InternalEList<?>)getB2s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B5S:
				return ((InternalEList<?>)getB5s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B3S:
				return ((InternalEList<?>)getB3s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B12S:
				return ((InternalEList<?>)getB12s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B6S:
				return ((InternalEList<?>)getB6s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B4S:
				return ((InternalEList<?>)getB4s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B7S:
				return ((InternalEList<?>)getB7s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B11S:
				return ((InternalEList<?>)getB11s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B10S:
				return ((InternalEList<?>)getB10s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B9S:
				return ((InternalEList<?>)getB9s()).basicRemove(otherEnd, msgs);
			case BmodelPackage.BMODEL__B8S:
				return ((InternalEList<?>)getB8s()).basicRemove(otherEnd, msgs);
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
			case BmodelPackage.BMODEL__B1S:
				return getB1s();
			case BmodelPackage.BMODEL__B2S:
				return getB2s();
			case BmodelPackage.BMODEL__B5S:
				return getB5s();
			case BmodelPackage.BMODEL__B3S:
				return getB3s();
			case BmodelPackage.BMODEL__B12S:
				return getB12s();
			case BmodelPackage.BMODEL__B6S:
				return getB6s();
			case BmodelPackage.BMODEL__B4S:
				return getB4s();
			case BmodelPackage.BMODEL__B7S:
				return getB7s();
			case BmodelPackage.BMODEL__B11S:
				return getB11s();
			case BmodelPackage.BMODEL__B10S:
				return getB10s();
			case BmodelPackage.BMODEL__B9S:
				return getB9s();
			case BmodelPackage.BMODEL__B8S:
				return getB8s();
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
			case BmodelPackage.BMODEL__B1S:
				getB1s().clear();
				getB1s().addAll((Collection<? extends B1>)newValue);
				return;
			case BmodelPackage.BMODEL__B2S:
				getB2s().clear();
				getB2s().addAll((Collection<? extends B2>)newValue);
				return;
			case BmodelPackage.BMODEL__B5S:
				getB5s().clear();
				getB5s().addAll((Collection<? extends B5>)newValue);
				return;
			case BmodelPackage.BMODEL__B3S:
				getB3s().clear();
				getB3s().addAll((Collection<? extends B3>)newValue);
				return;
			case BmodelPackage.BMODEL__B12S:
				getB12s().clear();
				getB12s().addAll((Collection<? extends B12>)newValue);
				return;
			case BmodelPackage.BMODEL__B6S:
				getB6s().clear();
				getB6s().addAll((Collection<? extends B6>)newValue);
				return;
			case BmodelPackage.BMODEL__B4S:
				getB4s().clear();
				getB4s().addAll((Collection<? extends B4>)newValue);
				return;
			case BmodelPackage.BMODEL__B7S:
				getB7s().clear();
				getB7s().addAll((Collection<? extends B7>)newValue);
				return;
			case BmodelPackage.BMODEL__B11S:
				getB11s().clear();
				getB11s().addAll((Collection<? extends B11>)newValue);
				return;
			case BmodelPackage.BMODEL__B10S:
				getB10s().clear();
				getB10s().addAll((Collection<? extends B10>)newValue);
				return;
			case BmodelPackage.BMODEL__B9S:
				getB9s().clear();
				getB9s().addAll((Collection<? extends B9>)newValue);
				return;
			case BmodelPackage.BMODEL__B8S:
				getB8s().clear();
				getB8s().addAll((Collection<? extends B8>)newValue);
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
			case BmodelPackage.BMODEL__B1S:
				getB1s().clear();
				return;
			case BmodelPackage.BMODEL__B2S:
				getB2s().clear();
				return;
			case BmodelPackage.BMODEL__B5S:
				getB5s().clear();
				return;
			case BmodelPackage.BMODEL__B3S:
				getB3s().clear();
				return;
			case BmodelPackage.BMODEL__B12S:
				getB12s().clear();
				return;
			case BmodelPackage.BMODEL__B6S:
				getB6s().clear();
				return;
			case BmodelPackage.BMODEL__B4S:
				getB4s().clear();
				return;
			case BmodelPackage.BMODEL__B7S:
				getB7s().clear();
				return;
			case BmodelPackage.BMODEL__B11S:
				getB11s().clear();
				return;
			case BmodelPackage.BMODEL__B10S:
				getB10s().clear();
				return;
			case BmodelPackage.BMODEL__B9S:
				getB9s().clear();
				return;
			case BmodelPackage.BMODEL__B8S:
				getB8s().clear();
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
			case BmodelPackage.BMODEL__B1S:
				return b1s != null && !b1s.isEmpty();
			case BmodelPackage.BMODEL__B2S:
				return b2s != null && !b2s.isEmpty();
			case BmodelPackage.BMODEL__B5S:
				return b5s != null && !b5s.isEmpty();
			case BmodelPackage.BMODEL__B3S:
				return b3s != null && !b3s.isEmpty();
			case BmodelPackage.BMODEL__B12S:
				return b12s != null && !b12s.isEmpty();
			case BmodelPackage.BMODEL__B6S:
				return b6s != null && !b6s.isEmpty();
			case BmodelPackage.BMODEL__B4S:
				return b4s != null && !b4s.isEmpty();
			case BmodelPackage.BMODEL__B7S:
				return b7s != null && !b7s.isEmpty();
			case BmodelPackage.BMODEL__B11S:
				return b11s != null && !b11s.isEmpty();
			case BmodelPackage.BMODEL__B10S:
				return b10s != null && !b10s.isEmpty();
			case BmodelPackage.BMODEL__B9S:
				return b9s != null && !b9s.isEmpty();
			case BmodelPackage.BMODEL__B8S:
				return b8s != null && !b8s.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BModelImpl
