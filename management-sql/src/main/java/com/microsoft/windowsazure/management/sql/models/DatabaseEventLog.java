/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.sql.models;

import java.util.Calendar;

/**
* Represents the event log entry for a database.
*/
public class DatabaseEventLog extends SqlModelCommon {
    private String additionalData;
    
    /**
    * Optional. Gets any additional data for the event log.
    * @return The AdditionalData value.
    */
    public String getAdditionalData() {
        return this.additionalData;
    }
    
    /**
    * Optional. Gets any additional data for the event log.
    * @param additionalDataValue The AdditionalData value.
    */
    public void setAdditionalData(final String additionalDataValue) {
        this.additionalData = additionalDataValue;
    }
    
    private String databaseName;
    
    /**
    * Optional. Gets the name of the database pertaining to this log.
    * @return The DatabaseName value.
    */
    public String getDatabaseName() {
        return this.databaseName;
    }
    
    /**
    * Optional. Gets the name of the database pertaining to this log.
    * @param databaseNameValue The DatabaseName value.
    */
    public void setDatabaseName(final String databaseNameValue) {
        this.databaseName = databaseNameValue;
    }
    
    private String description;
    
    /**
    * Optional. Gets the description of the event log.
    * @return The Description value.
    */
    public String getDescription() {
        return this.description;
    }
    
    /**
    * Optional. Gets the description of the event log.
    * @param descriptionValue The Description value.
    */
    public void setDescription(final String descriptionValue) {
        this.description = descriptionValue;
    }
    
    private String eventCategory;
    
    /**
    * Optional. Gets the event category of the event log.
    * @return The EventCategory value.
    */
    public String getEventCategory() {
        return this.eventCategory;
    }
    
    /**
    * Optional. Gets the event category of the event log.
    * @param eventCategoryValue The EventCategory value.
    */
    public void setEventCategory(final String eventCategoryValue) {
        this.eventCategory = eventCategoryValue;
    }
    
    private String eventSubtype;
    
    /**
    * Optional. Gets the event sub type of the event log.
    * @return The EventSubtype value.
    */
    public String getEventSubtype() {
        return this.eventSubtype;
    }
    
    /**
    * Optional. Gets the event sub type of the event log.
    * @param eventSubtypeValue The EventSubtype value.
    */
    public void setEventSubtype(final String eventSubtypeValue) {
        this.eventSubtype = eventSubtypeValue;
    }
    
    private String eventSubtypeDescription;
    
    /**
    * Optional. Gets the event sub type description of the event log.
    * @return The EventSubtypeDescription value.
    */
    public String getEventSubtypeDescription() {
        return this.eventSubtypeDescription;
    }
    
    /**
    * Optional. Gets the event sub type description of the event log.
    * @param eventSubtypeDescriptionValue The EventSubtypeDescription value.
    */
    public void setEventSubtypeDescription(final String eventSubtypeDescriptionValue) {
        this.eventSubtypeDescription = eventSubtypeDescriptionValue;
    }
    
    private String eventType;
    
    /**
    * Optional. Gets the event type of the event log.
    * @return The EventType value.
    */
    public String getEventType() {
        return this.eventType;
    }
    
    /**
    * Optional. Gets the event type of the event log.
    * @param eventTypeValue The EventType value.
    */
    public void setEventType(final String eventTypeValue) {
        this.eventType = eventTypeValue;
    }
    
    private int intervalSizeInMinutes;
    
    /**
    * Optional. Gets the interval size of the event log expressed in minutes.
    * @return The IntervalSizeInMinutes value.
    */
    public int getIntervalSizeInMinutes() {
        return this.intervalSizeInMinutes;
    }
    
    /**
    * Optional. Gets the interval size of the event log expressed in minutes.
    * @param intervalSizeInMinutesValue The IntervalSizeInMinutes value.
    */
    public void setIntervalSizeInMinutes(final int intervalSizeInMinutesValue) {
        this.intervalSizeInMinutes = intervalSizeInMinutesValue;
    }
    
    private int numberOfEvents;
    
    /**
    * Optional. Gets the number of events of the event log.
    * @return The NumberOfEvents value.
    */
    public int getNumberOfEvents() {
        return this.numberOfEvents;
    }
    
    /**
    * Optional. Gets the number of events of the event log.
    * @param numberOfEventsValue The NumberOfEvents value.
    */
    public void setNumberOfEvents(final int numberOfEventsValue) {
        this.numberOfEvents = numberOfEventsValue;
    }
    
    private int severity;
    
    /**
    * Optional. Gets the severity of the event log.
    * @return The Severity value.
    */
    public int getSeverity() {
        return this.severity;
    }
    
    /**
    * Optional. Gets the severity of the event log.
    * @param severityValue The Severity value.
    */
    public void setSeverity(final int severityValue) {
        this.severity = severityValue;
    }
    
    private Calendar startTimeUtc;
    
    /**
    * Optional. Gets the start time of the event log.
    * @return The StartTimeUtc value.
    */
    public Calendar getStartTimeUtc() {
        return this.startTimeUtc;
    }
    
    /**
    * Optional. Gets the start time of the event log.
    * @param startTimeUtcValue The StartTimeUtc value.
    */
    public void setStartTimeUtc(final Calendar startTimeUtcValue) {
        this.startTimeUtc = startTimeUtcValue;
    }
}
