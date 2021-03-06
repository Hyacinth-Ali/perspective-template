/**
 */
package ca.mcgill.sel.amodel.provider;

import ca.mcgill.sel.amodel.util.AmodelAdapterFactory;

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
public class AmodelItemProviderAdapterFactory extends AmodelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public AmodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.AModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AModelItemProvider aModelItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.AModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAModelAdapter() {
		if (aModelItemProvider == null) {
			aModelItemProvider = new AModelItemProvider(this);
		}

		return aModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A1} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A1ItemProvider a1ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A1}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA1Adapter() {
		if (a1ItemProvider == null) {
			a1ItemProvider = new A1ItemProvider(this);
		}

		return a1ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A2} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A2ItemProvider a2ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A2}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA2Adapter() {
		if (a2ItemProvider == null) {
			a2ItemProvider = new A2ItemProvider(this);
		}

		return a2ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A3} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A3ItemProvider a3ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A3}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA3Adapter() {
		if (a3ItemProvider == null) {
			a3ItemProvider = new A3ItemProvider(this);
		}

		return a3ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A4} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A4ItemProvider a4ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A4}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA4Adapter() {
		if (a4ItemProvider == null) {
			a4ItemProvider = new A4ItemProvider(this);
		}

		return a4ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A5} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A5ItemProvider a5ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A5}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA5Adapter() {
		if (a5ItemProvider == null) {
			a5ItemProvider = new A5ItemProvider(this);
		}

		return a5ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A6} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A6ItemProvider a6ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A6}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA6Adapter() {
		if (a6ItemProvider == null) {
			a6ItemProvider = new A6ItemProvider(this);
		}

		return a6ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A7} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A7ItemProvider a7ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A7}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA7Adapter() {
		if (a7ItemProvider == null) {
			a7ItemProvider = new A7ItemProvider(this);
		}

		return a7ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A8} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A8ItemProvider a8ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A8}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA8Adapter() {
		if (a8ItemProvider == null) {
			a8ItemProvider = new A8ItemProvider(this);
		}

		return a8ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A9} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A9ItemProvider a9ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A9}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA9Adapter() {
		if (a9ItemProvider == null) {
			a9ItemProvider = new A9ItemProvider(this);
		}

		return a9ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A10} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A10ItemProvider a10ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A10}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA10Adapter() {
		if (a10ItemProvider == null) {
			a10ItemProvider = new A10ItemProvider(this);
		}

		return a10ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A11} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A11ItemProvider a11ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A11}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA11Adapter() {
		if (a11ItemProvider == null) {
			a11ItemProvider = new A11ItemProvider(this);
		}

		return a11ItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.mcgill.sel.amodel.A12} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A12ItemProvider a12ItemProvider;

	/**
	 * This creates an adapter for a {@link ca.mcgill.sel.amodel.A12}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createA12Adapter() {
		if (a12ItemProvider == null) {
			a12ItemProvider = new A12ItemProvider(this);
		}

		return a12ItemProvider;
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
		if (aModelItemProvider != null) aModelItemProvider.dispose();
		if (a1ItemProvider != null) a1ItemProvider.dispose();
		if (a2ItemProvider != null) a2ItemProvider.dispose();
		if (a3ItemProvider != null) a3ItemProvider.dispose();
		if (a4ItemProvider != null) a4ItemProvider.dispose();
		if (a5ItemProvider != null) a5ItemProvider.dispose();
		if (a6ItemProvider != null) a6ItemProvider.dispose();
		if (a7ItemProvider != null) a7ItemProvider.dispose();
		if (a8ItemProvider != null) a8ItemProvider.dispose();
		if (a9ItemProvider != null) a9ItemProvider.dispose();
		if (a10ItemProvider != null) a10ItemProvider.dispose();
		if (a11ItemProvider != null) a11ItemProvider.dispose();
		if (a12ItemProvider != null) a12ItemProvider.dispose();
	}

}
