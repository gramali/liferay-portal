/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.dynamicdatamapping.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.dynamicdatamapping.model.DDMContent;
import com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureService;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMContentPersistence;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructureLinkPersistence;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructurePersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the d d m content local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.dynamicdatamapping.service.impl.DDMContentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.dynamicdatamapping.service.impl.DDMContentLocalServiceImpl
 * @see com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalServiceUtil
 * @generated
 */
public abstract class DDMContentLocalServiceBaseImpl
	implements DDMContentLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalServiceUtil} to access the d d m content local service.
	 */

	/**
	 * Adds the d d m content to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmContent the d d m content to add
	 * @return the d d m content that was added
	 * @throws SystemException if a system exception occurred
	 */
	public DDMContent addDDMContent(DDMContent ddmContent)
		throws SystemException {
		ddmContent.setNew(true);

		return ddmContentPersistence.update(ddmContent, false);
	}

	/**
	 * Creates a new d d m content with the primary key. Does not add the d d m content to the database.
	 *
	 * @param contentId the primary key for the new d d m content
	 * @return the new d d m content
	 */
	public DDMContent createDDMContent(long contentId) {
		return ddmContentPersistence.create(contentId);
	}

	/**
	 * Deletes the d d m content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the d d m content to delete
	 * @throws PortalException if a d d m content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDDMContent(long contentId)
		throws PortalException, SystemException {
		ddmContentPersistence.remove(contentId);
	}

	/**
	 * Deletes the d d m content from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmContent the d d m content to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDDMContent(DDMContent ddmContent)
		throws SystemException {
		ddmContentPersistence.remove(ddmContent);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return ddmContentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return ddmContentPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return ddmContentPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return ddmContentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the d d m content with the primary key.
	 *
	 * @param contentId the primary key of the d d m content to get
	 * @return the d d m content
	 * @throws PortalException if a d d m content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DDMContent getDDMContent(long contentId)
		throws PortalException, SystemException {
		return ddmContentPersistence.findByPrimaryKey(contentId);
	}

	/**
	 * Gets the d d m content with the UUID and group id.
	 *
	 * @param uuid the UUID of d d m content to get
	 * @param groupId the group id of the d d m content to get
	 * @return the d d m content
	 * @throws PortalException if a d d m content with the UUID and group id could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DDMContent getDDMContentByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return ddmContentPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Gets a range of all the d d m contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of d d m contents to return
	 * @param end the upper bound of the range of d d m contents to return (not inclusive)
	 * @return the range of d d m contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<DDMContent> getDDMContents(int start, int end)
		throws SystemException {
		return ddmContentPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of d d m contents.
	 *
	 * @return the number of d d m contents
	 * @throws SystemException if a system exception occurred
	 */
	public int getDDMContentsCount() throws SystemException {
		return ddmContentPersistence.countAll();
	}

	/**
	 * Updates the d d m content in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmContent the d d m content to update
	 * @return the d d m content that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DDMContent updateDDMContent(DDMContent ddmContent)
		throws SystemException {
		ddmContent.setNew(false);

		return ddmContentPersistence.update(ddmContent, true);
	}

	/**
	 * Updates the d d m content in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmContent the d d m content to update
	 * @param merge whether to merge the d d m content with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the d d m content that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DDMContent updateDDMContent(DDMContent ddmContent, boolean merge)
		throws SystemException {
		ddmContent.setNew(false);

		return ddmContentPersistence.update(ddmContent, merge);
	}

	/**
	 * Gets the d d m content local service.
	 *
	 * @return the d d m content local service
	 */
	public DDMContentLocalService getDDMContentLocalService() {
		return ddmContentLocalService;
	}

	/**
	 * Sets the d d m content local service.
	 *
	 * @param ddmContentLocalService the d d m content local service
	 */
	public void setDDMContentLocalService(
		DDMContentLocalService ddmContentLocalService) {
		this.ddmContentLocalService = ddmContentLocalService;
	}

	/**
	 * Gets the d d m content persistence.
	 *
	 * @return the d d m content persistence
	 */
	public DDMContentPersistence getDDMContentPersistence() {
		return ddmContentPersistence;
	}

	/**
	 * Sets the d d m content persistence.
	 *
	 * @param ddmContentPersistence the d d m content persistence
	 */
	public void setDDMContentPersistence(
		DDMContentPersistence ddmContentPersistence) {
		this.ddmContentPersistence = ddmContentPersistence;
	}

	/**
	 * Gets the d d m structure local service.
	 *
	 * @return the d d m structure local service
	 */
	public DDMStructureLocalService getDDMStructureLocalService() {
		return ddmStructureLocalService;
	}

	/**
	 * Sets the d d m structure local service.
	 *
	 * @param ddmStructureLocalService the d d m structure local service
	 */
	public void setDDMStructureLocalService(
		DDMStructureLocalService ddmStructureLocalService) {
		this.ddmStructureLocalService = ddmStructureLocalService;
	}

	/**
	 * Gets the d d m structure remote service.
	 *
	 * @return the d d m structure remote service
	 */
	public DDMStructureService getDDMStructureService() {
		return ddmStructureService;
	}

	/**
	 * Sets the d d m structure remote service.
	 *
	 * @param ddmStructureService the d d m structure remote service
	 */
	public void setDDMStructureService(DDMStructureService ddmStructureService) {
		this.ddmStructureService = ddmStructureService;
	}

	/**
	 * Gets the d d m structure persistence.
	 *
	 * @return the d d m structure persistence
	 */
	public DDMStructurePersistence getDDMStructurePersistence() {
		return ddmStructurePersistence;
	}

	/**
	 * Sets the d d m structure persistence.
	 *
	 * @param ddmStructurePersistence the d d m structure persistence
	 */
	public void setDDMStructurePersistence(
		DDMStructurePersistence ddmStructurePersistence) {
		this.ddmStructurePersistence = ddmStructurePersistence;
	}

	/**
	 * Gets the d d m structure link local service.
	 *
	 * @return the d d m structure link local service
	 */
	public DDMStructureLinkLocalService getDDMStructureLinkLocalService() {
		return ddmStructureLinkLocalService;
	}

	/**
	 * Sets the d d m structure link local service.
	 *
	 * @param ddmStructureLinkLocalService the d d m structure link local service
	 */
	public void setDDMStructureLinkLocalService(
		DDMStructureLinkLocalService ddmStructureLinkLocalService) {
		this.ddmStructureLinkLocalService = ddmStructureLinkLocalService;
	}

	/**
	 * Gets the d d m structure link remote service.
	 *
	 * @return the d d m structure link remote service
	 */
	public DDMStructureLinkService getDDMStructureLinkService() {
		return ddmStructureLinkService;
	}

	/**
	 * Sets the d d m structure link remote service.
	 *
	 * @param ddmStructureLinkService the d d m structure link remote service
	 */
	public void setDDMStructureLinkService(
		DDMStructureLinkService ddmStructureLinkService) {
		this.ddmStructureLinkService = ddmStructureLinkService;
	}

	/**
	 * Gets the d d m structure link persistence.
	 *
	 * @return the d d m structure link persistence
	 */
	public DDMStructureLinkPersistence getDDMStructureLinkPersistence() {
		return ddmStructureLinkPersistence;
	}

	/**
	 * Sets the d d m structure link persistence.
	 *
	 * @param ddmStructureLinkPersistence the d d m structure link persistence
	 */
	public void setDDMStructureLinkPersistence(
		DDMStructureLinkPersistence ddmStructureLinkPersistence) {
		this.ddmStructureLinkPersistence = ddmStructureLinkPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Gets the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ddmContentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DDMContentLocalService.class)
	protected DDMContentLocalService ddmContentLocalService;
	@BeanReference(type = DDMContentPersistence.class)
	protected DDMContentPersistence ddmContentPersistence;
	@BeanReference(type = DDMStructureLocalService.class)
	protected DDMStructureLocalService ddmStructureLocalService;
	@BeanReference(type = DDMStructureService.class)
	protected DDMStructureService ddmStructureService;
	@BeanReference(type = DDMStructurePersistence.class)
	protected DDMStructurePersistence ddmStructurePersistence;
	@BeanReference(type = DDMStructureLinkLocalService.class)
	protected DDMStructureLinkLocalService ddmStructureLinkLocalService;
	@BeanReference(type = DDMStructureLinkService.class)
	protected DDMStructureLinkService ddmStructureLinkService;
	@BeanReference(type = DDMStructureLinkPersistence.class)
	protected DDMStructureLinkPersistence ddmStructureLinkPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	private String _beanIdentifier;
}