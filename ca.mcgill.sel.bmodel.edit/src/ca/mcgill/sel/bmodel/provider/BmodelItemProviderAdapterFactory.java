/**
 */
package ca.mcgill.sel.bmodel.provider;

import ca.mcgill.sel.bmodel.util.BmodelAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BmodelItemProviderAdapterFactory extends BmodelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.BModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BModelItemProvider bModelItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.BModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBModelAdapter() {
		if (bModelItemProvider == null) {
			bModelItemProvider = new BModelItemProvider(this);
		}

		return bModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B1} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B1ItemProvider b1ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B1}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB1Adapter() {
		if (b1ItemProvider == null) {
			b1ItemProvider = new B1ItemProvider(this);
		}

		return b1ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B2} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B2ItemProvider b2ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B2}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB2Adapter() {
		if (b2ItemProvider == null) {
			b2ItemProvider = new B2ItemProvider(this);
		}

		return b2ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B3} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B3ItemProvider b3ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B3}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB3Adapter() {
		if (b3ItemProvider == null) {
			b3ItemProvider = new B3ItemProvider(this);
		}

		return b3ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B4} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B4ItemProvider b4ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B4}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB4Adapter() {
		if (b4ItemProvider == null) {
			b4ItemProvider = new B4ItemProvider(this);
		}

		return b4ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B5} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B5ItemProvider b5ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B5}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB5Adapter() {
		if (b5ItemProvider == null) {
			b5ItemProvider = new B5ItemProvider(this);
		}

		return b5ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B6} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B6ItemProvider b6ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B6}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB6Adapter() {
		if (b6ItemProvider == null) {
			b6ItemProvider = new B6ItemProvider(this);
		}

		return b6ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B7} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B7ItemProvider b7ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B7}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB7Adapter() {
		if (b7ItemProvider == null) {
			b7ItemProvider = new B7ItemProvider(this);
		}

		return b7ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B8} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B8ItemProvider b8ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B8}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB8Adapter() {
		if (b8ItemProvider == null) {
			b8ItemProvider = new B8ItemProvider(this);
		}

		return b8ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B9} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B9ItemProvider b9ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B9}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB9Adapter() {
		if (b9ItemProvider == null) {
			b9ItemProvider = new B9ItemProvider(this);
		}

		return b9ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B10} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B10ItemProvider b10ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B10}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB10Adapter() {
		if (b10ItemProvider == null) {
			b10ItemProvider = new B10ItemProvider(this);
		}

		return b10ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B11} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B11ItemProvider b11ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B11}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB11Adapter() {
		if (b11ItemProvider == null) {
			b11ItemProvider = new B11ItemProvider(this);
		}

		return b11ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.bmodel.B12} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B12ItemProvider b12ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.bmodel.B12}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createB12Adapter() {
		if (b12ItemProvider == null) {
			b12ItemProvider = new B12ItemProvider(this);
		}

		return b12ItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (bModelItemProvider != null) bModelItemProvider.dispose();
		if (b1ItemProvider != null) b1ItemProvider.dispose();
		if (b2ItemProvider != null) b2ItemProvider.dispose();
		if (b3ItemProvider != null) b3ItemProvider.dispose();
		if (b4ItemProvider != null) b4ItemProvider.dispose();
		if (b5ItemProvider != null) b5ItemProvider.dispose();
		if (b6ItemProvider != null) b6ItemProvider.dispose();
		if (b7ItemProvider != null) b7ItemProvider.dispose();
		if (b8ItemProvider != null) b8ItemProvider.dispose();
		if (b9ItemProvider != null) b9ItemProvider.dispose();
		if (b10ItemProvider != null) b10ItemProvider.dispose();
		if (b11ItemProvider != null) b11ItemProvider.dispose();
		if (b12ItemProvider != null) b12ItemProvider.dispose();
	}

}
