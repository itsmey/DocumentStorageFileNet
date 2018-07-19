package ru.bikert.fileNet.TypeContainable;

import com.filenet.api.action.PendingAction;
import com.filenet.api.admin.StorageArea;
import com.filenet.api.admin.StoragePolicy;
import com.filenet.api.collection.*;
import com.filenet.api.constants.*;
import com.filenet.api.core.*;
import com.filenet.api.events.CustomEvent;
import com.filenet.api.events.DocumentLifecyclePolicy;
import com.filenet.api.meta.ClassDescription;
import com.filenet.api.property.Properties;
import com.filenet.api.property.Property;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.publishing.PublishRequest;
import com.filenet.api.publishing.PublishTemplate;
import com.filenet.api.replication.ReplicationGroup;
import com.filenet.api.security.SecurityPolicy;
import com.filenet.api.util.Id;

import java.io.InputStream;
import java.util.Date;

public class ContractDocument extends APDocument {




    public StoragePolicy get_StoragePolicy() {
        return null;
    }

    public void set_StoragePolicy(StoragePolicy storagePolicy) {

    }

    public String get_StorageLocation() {
        return null;
    }

    public StringList get_ContentElementsPresent() {
        return null;
    }

    public ContentElementList get_ContentElements() {
        return null;
    }

    public void set_ContentElements(ContentElementList contentElementList) {

    }

    public Double get_ContentSize() {
        return null;
    }

    public String get_MimeType() {
        return null;
    }

    public void set_MimeType(String s) {

    }

    public Date get_DateContentLastAccessed() {
        return null;
    }

    public Date get_ContentRetentionDate() {
        return null;
    }

    public DocumentLifecyclePolicy get_DocumentLifecyclePolicy() {
        return null;
    }

    public void set_DocumentLifecyclePolicy(DocumentLifecyclePolicy documentLifecyclePolicy) {

    }

    public String get_CurrentState() {
        return null;
    }

    public Boolean get_IsInExceptionState() {
        return null;
    }

    public InstanceWorkflowSubscriptionSet get_WorkflowSubscriptions() {
        return null;
    }

    public DocClassificationStatus get_ClassificationStatus() {
        return null;
    }

    public StorageArea get_StorageArea() {
        return null;
    }

    public void set_StorageArea(StorageArea storageArea) {

    }

    public Id get_IndexationId() {
        return null;
    }

    public Integer get_CmIndexingFailureCode() {
        return null;
    }

    public CompoundDocumentState get_CompoundDocumentState() {
        return null;
    }

    public void set_CompoundDocumentState(CompoundDocumentState compoundDocumentState) {

    }

    public DocumentSet get_ChildDocuments() {
        return null;
    }

    public ComponentRelationshipSet get_ChildRelationships() {
        return null;
    }

    public DocumentSet get_ParentDocuments() {
        return null;
    }

    public ComponentRelationshipSet get_ParentRelationships() {
        return null;
    }

    public Date get_CmRetentionDate() {
        return null;
    }

    public void set_CmRetentionDate(Date date) {

    }

    public Document get_SourceDocument() {
        return null;
    }

    public void set_SourceDocument(Document document) {

    }

    public DocumentSet get_DestinationDocuments() {
        return null;
    }

    public Document get_OwnerDocument() {
        return null;
    }

    public void set_OwnerDocument(Document document) {

    }

    public DocumentSet get_DependentDocuments() {
        return null;
    }

    public byte[] get_PublicationInfo() {
        return new byte[0];
    }

    public void set_PublicationInfo(byte[] bytes) {

    }

    public Folder get_PublishingSubsidiaryFolder() {
        return null;
    }

    public void set_PublishingSubsidiaryFolder(Folder folder) {

    }

    public CmThumbnailSet get_CmThumbnails() {
        return null;
    }

    public void takeFederatedOwnership() {

    }

    public void changeState(LifecycleChangeFlags lifecycleChangeFlags) {

    }

    public PublicationStatus getPublicationStatus() {
        return null;
    }

    public PublishRequest republish(Document document, String s) {
        return null;
    }

    public PublishRequest publish(PublishTemplate publishTemplate, String s) {
        return null;
    }

    public void checkin(AutoClassify autoClassify, CheckinType checkinType) {

    }

    public void applySecurityTemplate(Id id) {

    }

    public InputStream accessContentStream(int i) {
        return null;
    }

    public void lock(int i, String s) {

    }

    public void moveContent(StorageArea storageArea) {

    }

    public Boolean isLocked() {
        return null;
    }

    public void updateLock(long l) {

    }

    public void unlock() {

    }

    public void set_SecurityParent(ReferentialContainmentRelationship referentialContainmentRelationship) {

    }

    public ReferentialContainmentRelationship get_SecurityParent() {
        return null;
    }

    public Versionable get_ReleasedVersion() {
        return null;
    }

    public FolderSet get_FoldersFiledIn() {
        return null;
    }

    public Folder get_SecurityFolder() {
        return null;
    }

    public void set_SecurityFolder(Folder folder) {

    }

    public Boolean get_IsReserved() {
        return null;
    }

    public Boolean get_IsCurrentVersion() {
        return null;
    }

    public Boolean get_IsFrozenVersion() {
        return null;
    }

    public VersionSeries get_VersionSeries() {
        return null;
    }

    public VersionableSet get_Versions() {
        return null;
    }

    public IndependentObject get_Reservation() {
        return null;
    }

    public Boolean get_IsVersioningEnabled() {
        return null;
    }

    public Integer get_MajorVersionNumber() {
        return null;
    }

    public Integer get_MinorVersionNumber() {
        return null;
    }

    public VersionStatus get_VersionStatus() {
        return null;
    }

    public ReservationType get_ReservationType() {
        return null;
    }

    public Date get_DateCheckedIn() {
        return null;
    }

    public void set_DateCheckedIn(Date date) {

    }

    public Boolean get_CmIsMarkedForDeletion() {
        return null;
    }

    public void checkout(ReservationType reservationType, Id id, String s, Properties properties) {

    }

    public void freeze() {

    }

    public Annotation createAnnotation(int i, String s) {
        return null;
    }

    public void promoteVersion() {

    }

    public Versionable cancelCheckout() {
        return null;
    }

    public void demoteVersion() {

    }

    public void changeClass(String s) {

    }

    public Versionable get_CurrentVersion() {
        return null;
    }

    public CmHoldRelationshipSet get_CmHoldRelationships() {
        return null;
    }

    public String get_Creator() {
        return null;
    }

    public void set_Creator(String s) {

    }

    public Date get_DateCreated() {
        return null;
    }

    public void set_DateCreated(Date date) {

    }

    public String get_LastModifier() {
        return null;
    }

    public void set_LastModifier(String s) {

    }

    public Date get_DateLastModified() {
        return null;
    }

    public void set_DateLastModified(Date date) {

    }

    public Id get_Id() {
        return null;
    }

    public String get_Name() {
        return null;
    }

    public EventSet get_AuditedEvents() {
        return null;
    }

    public String get_Owner() {
        return null;
    }

    public void set_Owner(String s) {

    }

    public AccessPermissionList get_Permissions() {
        return null;
    }

    public void set_Permissions(AccessPermissionList accessPermissionList) {

    }

    public ActiveMarkingList get_ActiveMarkings() {
        return null;
    }

    public ReferentialContainmentRelationshipSet get_Containers() {
        return null;
    }

    public AnnotationSet get_Annotations() {
        return null;
    }

    public Id get_LockToken() {
        return null;
    }

    public Integer get_LockTimeout() {
        return null;
    }

    public String get_LockOwner() {
        return null;
    }

    public SecurityPolicy get_SecurityPolicy() {
        return null;
    }

    public void set_SecurityPolicy(SecurityPolicy securityPolicy) {

    }

    public CmTaskSet get_CoordinatedTasks() {
        return null;
    }

    public Integer getUpdateSequenceNumber() {
        return null;
    }

    public void setUpdateSequenceNumber(Integer integer) {

    }

    public Boolean isCurrent() {
        return null;
    }

    public void delete() {

    }

    public void save(RefreshMode refreshMode) {

    }

    public void save(RefreshMode refreshMode, PropertyFilter propertyFilter) {

    }

    public PendingAction[] getPendingActions() {
        return new PendingAction[0];
    }

    public void addPendingAction(PendingAction pendingAction) {

    }

    public void clearPendingActions() {

    }

    public Integer getAccessAllowed() {
        return null;
    }

    public void refresh() {

    }

    public void refresh(String[] strings) {

    }

    public void refresh(PropertyFilter propertyFilter) {

    }

    public void fetchProperties(String[] strings) {

    }

    public void fetchProperties(PropertyFilter propertyFilter) {

    }

    public Property fetchProperty(String s, PropertyFilter propertyFilter) {
        return null;
    }

    public Property fetchProperty(String s, PropertyFilter propertyFilter, Integer integer) {
        return null;
    }

    public ObjectReference getObjectReference() {
        return null;
    }

    public ClassDescription get_ClassDescription() {
        return null;
    }

    public Connection getConnection() {
        return null;
    }

    public Properties getProperties() {
        return null;
    }

    public String getClassName() {
        return null;
    }

    public String[] getSuperClasses() {
        return new String[0];
    }

    public ObjectStore getObjectStore() {
        return null;
    }

    public void raiseEvent(CustomEvent customEvent) {

    }

    public ReplicationGroup get_ReplicationGroup() {
        return null;
    }

    public void set_ReplicationGroup(ReplicationGroup replicationGroup) {

    }

    public ExternalIdentityList get_ExternalReplicaIdentities() {
        return null;
    }

    public void set_ExternalReplicaIdentities(ExternalIdentityList externalIdentityList) {

    }
}
