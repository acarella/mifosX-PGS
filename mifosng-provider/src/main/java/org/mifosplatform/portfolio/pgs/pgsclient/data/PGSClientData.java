/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.pgs.pgsclient.data;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.joda.time.LocalDate;
import org.mifosplatform.infrastructure.codes.data.CodeValueData;
import org.mifosplatform.infrastructure.core.data.EnumOptionData;
import org.mifosplatform.organisation.office.data.OfficeData;
import org.mifosplatform.organisation.staff.data.StaffData;
import org.mifosplatform.portfolio.group.data.GroupGeneralData;
import org.mifosplatform.portfolio.savings.data.SavingsAccountData;
import org.mifosplatform.portfolio.savings.data.SavingsProductData;

/**
 * Immutable data object representing client data.
 */
final public class PGSClientData implements Comparable<PGSClientData> {

    private final Long id;
    private final String accountNo;
    private final String externalId;

    private final EnumOptionData status;
    @SuppressWarnings("unused")
    private final Boolean active;
    private final LocalDate activationDate;

    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String fullname;
    private final String displayName;
    private final String mobileNo;
    private final LocalDate dateOfBirth;
    private final CodeValueData gender;

    private final Long officeId;
    private final String officeName;
    private final Long transferToOfficeId;
    private final String transferToOfficeName;

    private final Long imageId;
    private final Boolean imagePresent;
    private final Long staffId;
    private final String staffName;
    private final PGSClientTimelineData timeline;

    private final Long savingsProductId;
    private final String savingsProductName;

    private final Long savingsAccountId;
    private final Long mifosClientId;
    private final Long serviceAccountId;

    // associations
    private final Collection<GroupGeneralData> groups;

    // template
    private final Collection<OfficeData> officeOptions;
    private final Collection<StaffData> staffOptions;
    private final Collection<CodeValueData> closureReasons;
    private final Collection<SavingsProductData> savingProductOptions;
    private final Collection<SavingsAccountData> savingAccountOptions;
    private final Collection<CodeValueData> genderOptions;

    public static PGSClientData template(final Long officeId, final LocalDate joinedDate, final Collection<OfficeData> officeOptions,
            final Collection<StaffData> staffOptions, final Collection<CodeValueData> closureReasons,
            final Collection<CodeValueData> genderOptions, final Collection<SavingsProductData> savingProductOptions) {
        return new PGSClientData(null, null, officeId, null, null, null, null, null, null, null, null, null, null, null, null, null,
                joinedDate, null, null, null, officeOptions, null, staffOptions, closureReasons, genderOptions, null, savingProductOptions, null, null,
                null, null, null, null);
    }

    public static PGSClientData templateOnTop(final PGSClientData clientData, final PGSClientData templateData) {

        return new PGSClientData(clientData.accountNo, clientData.status, clientData.officeId, clientData.officeName,
                clientData.transferToOfficeId, clientData.transferToOfficeName, clientData.id, clientData.firstname, clientData.middlename,
                clientData.lastname, clientData.fullname, clientData.displayName, clientData.externalId, clientData.mobileNo,
                clientData.dateOfBirth, clientData.gender, clientData.activationDate, clientData.imageId, clientData.staffId,
                clientData.staffName, templateData.officeOptions, clientData.groups, templateData.staffOptions, templateData.closureReasons, templateData.genderOptions, clientData.timeline,
                templateData.savingProductOptions, clientData.savingsProductId, clientData.savingsProductName, clientData.savingsAccountId,
                clientData.savingAccountOptions, clientData.mifosClientId, clientData.serviceAccountId);

    }

    public static PGSClientData templateWithSavingAccountOptions(final PGSClientData clientData,
            final Collection<SavingsAccountData> savingAccountOptions) {

        return new PGSClientData(clientData.accountNo, clientData.status, clientData.officeId, clientData.officeName,
                clientData.transferToOfficeId, clientData.transferToOfficeName, clientData.id, clientData.firstname, clientData.middlename,
                clientData.lastname, clientData.fullname, clientData.displayName, clientData.externalId, clientData.mobileNo,
                clientData.dateOfBirth, clientData.gender, clientData.activationDate, clientData.imageId, clientData.staffId,
                clientData.staffName, clientData.officeOptions, clientData.groups, clientData.staffOptions, null, null, null,
                clientData.savingProductOptions, clientData.savingsProductId, clientData.savingsProductName, clientData.savingsAccountId,
                savingAccountOptions, clientData.mifosClientId, clientData.serviceAccountId);

    }

    public static PGSClientData setParentGroups(final PGSClientData clientData, final Collection<GroupGeneralData> parentGroups) {
        return new PGSClientData(clientData.accountNo, clientData.status, clientData.officeId, clientData.officeName,
                clientData.transferToOfficeId, clientData.transferToOfficeName, clientData.id, clientData.firstname, clientData.middlename,
                clientData.lastname, clientData.fullname, clientData.displayName, clientData.externalId, clientData.mobileNo,
                clientData.dateOfBirth, clientData.gender, clientData.activationDate, clientData.imageId, clientData.staffId,
                clientData.staffName, clientData.officeOptions, parentGroups, clientData.staffOptions, null, null, clientData.timeline,
                clientData.savingProductOptions, clientData.savingsProductId, clientData.savingsProductName, clientData.savingsAccountId,
                clientData.savingAccountOptions, clientData.mifosClientId, clientData.serviceAccountId);

    }

    public static PGSClientData clientIdentifier(final Long id, final String accountNo, final EnumOptionData status, final String firstname,
            final String middlename, final String lastname, final String fullname, final String displayName, final Long officeId,
            final String officeName) {

        return new PGSClientData(accountNo, status, officeId, officeName, null, null, id, firstname, middlename, lastname, fullname,
                displayName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
                null, null);

    }

    public static PGSClientData lookup(final Long id, final String displayName, final Long officeId, final String officeName) {
        return new PGSClientData(null, null, officeId, officeName, null, null, id, null, null, null, null, displayName, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    }

    public static PGSClientData instance(final String accountNo, final EnumOptionData status, final Long officeId, final String officeName,
            final Long transferToOfficeId, final String transferToOfficeName, final Long id, final String firstname,
            final String middlename, final String lastname, final String fullname, final String displayName, final String externalId,
            final String mobileNo, final LocalDate dateOfBirth, final CodeValueData gender, final LocalDate activationDate,
            final Long imageId, final Long staffId, final String staffName, final PGSClientTimelineData timeline, final Long savingsProductId,
            final String savingsProductName, final Long savingsAccountId, final Long mifosClientId, final Long serviceAcccountId) {
        return new PGSClientData(accountNo, status, officeId, officeName, transferToOfficeId, transferToOfficeName, id, firstname, middlename,
                lastname, fullname, displayName, externalId, mobileNo, dateOfBirth, gender, activationDate, imageId, staffId, staffName,
                null, null, null, null, null, timeline, null, savingsProductId, savingsProductName, savingsAccountId, null, mifosClientId, serviceAcccountId);

    }

    private PGSClientData(final String accountNo, final EnumOptionData status, final Long officeId, final String officeName,
            final Long transferToOfficeId, final String transferToOfficeName, final Long id, final String firstname,
            final String middlename, final String lastname, final String fullname, final String displayName, final String externalId,
            final String mobileNo, final LocalDate dateOfBirth, final CodeValueData gender, final LocalDate activationDate,
            final Long imageId, final Long staffId, final String staffName, final Collection<OfficeData> allowedOffices,
            final Collection<GroupGeneralData> groups, final Collection<StaffData> staffOptions,
            final Collection<CodeValueData> closureReasons, final Collection<CodeValueData> genderOptions, final PGSClientTimelineData timeline,
            final Collection<SavingsProductData> savingProductOptions, final Long savingsProductId, final String savingsProductName,
            final Long savingsAccountId, final Collection<SavingsAccountData> savingAccountOptions, final Long mifosClientId, final Long serviceAccountId) {
        this.accountNo = accountNo;
        this.status = status;
        if (status != null) {
            this.active = status.getId().equals(300L);
        } else {
            this.active = null;
        }
        this.officeId = officeId;
        this.officeName = officeName;
        this.transferToOfficeId = transferToOfficeId;
        this.transferToOfficeName = transferToOfficeName;
        this.id = id;
        this.firstname = StringUtils.defaultIfEmpty(firstname, null);
        this.middlename = StringUtils.defaultIfEmpty(middlename, null);
        this.lastname = StringUtils.defaultIfEmpty(lastname, null);
        this.fullname = StringUtils.defaultIfEmpty(fullname, null);
        this.displayName = StringUtils.defaultIfEmpty(displayName, null);
        this.externalId = StringUtils.defaultIfEmpty(externalId, null);
        this.mobileNo = StringUtils.defaultIfEmpty(mobileNo, null);
        this.activationDate = activationDate;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.imageId = imageId;
        if (imageId != null) {
            this.imagePresent = Boolean.TRUE;
        } else {
            this.imagePresent = null;
        }
        this.staffId = staffId;
        this.staffName = staffName;

        // associations
        this.groups = groups;

        // template
        this.officeOptions = allowedOffices;
        this.staffOptions = staffOptions;
        this.closureReasons = closureReasons;
        this.genderOptions = genderOptions;

        this.timeline = timeline;
        this.savingProductOptions = savingProductOptions;
        this.savingsProductId = savingsProductId;
        this.savingsProductName = savingsProductName;
        this.savingsAccountId = savingsAccountId;
        this.savingAccountOptions = savingAccountOptions;
        this.mifosClientId = mifosClientId;
        this.serviceAccountId = serviceAccountId;
    }

    public Long id() {
        return this.id;
    }

    public String displayName() {
        return this.displayName;
    }

    public Long officeId() {
        return this.officeId;
    }

    public String officeName() {
        return this.officeName;
    }

    public Long getImageId() {
        return this.imageId;
    }

    public Boolean getImagePresent() {
        return this.imagePresent;
    }

    public PGSClientTimelineData getTimeline() {
        return this.timeline;
    }

    @Override
    public int compareTo(final PGSClientData obj) {
        if (obj == null) { return -1; }
        return new CompareToBuilder() //
                .append(this.id, obj.id) //
                .append(this.displayName, obj.displayName) //
                .append(this.mobileNo, obj.mobileNo) //
                .toComparison();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) { return false; }
        final PGSClientData rhs = (PGSClientData) obj;
        return new EqualsBuilder() //
                .append(this.id, rhs.id) //
                .append(this.displayName, rhs.displayName) //
                .append(this.mobileNo, rhs.mobileNo) //
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37) //
                .append(this.id) //
                .append(this.displayName) //
                .toHashCode();
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public LocalDate getActivationDate() {
        return this.activationDate;
    }
}