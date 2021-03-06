/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.miio.internal.basic;

import static org.openhab.binding.miio.internal.MiIoBindingConstants.BINDING_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Mapping properties from json
 *
 * @author Marcel Verpaalen - Initial contribution
 */
@NonNullByDefault
public class MiIoBasicChannel {

    @SerializedName("property")
    @Expose
    private @Nullable String property;
    @SerializedName("friendlyName")
    @Expose
    private @Nullable String friendlyName;
    @SerializedName("channel")
    @Expose
    private @Nullable String channel;
    @SerializedName("channelType")
    @Expose
    private @Nullable String channelType;
    @SerializedName("type")
    @Expose
    private @Nullable String type;
    @SerializedName("refresh")
    @Expose
    private @Nullable Boolean refresh;
    @SerializedName("transformation")
    @Expose
    private @Nullable String transfortmation;
    @SerializedName("ChannelGroup")
    @Expose
    private @Nullable String channelGroup;
    @SerializedName("actions")
    @Expose
    private @Nullable List<MiIoDeviceAction> miIoDeviceActions = new ArrayList<>();

    public String getProperty() {
        final String property = this.property;
        return (property != null) ? property : "";
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getFriendlyName() {
        final String fn = friendlyName;
        return (fn == null || type == null || fn.isEmpty()) ? getChannel() : fn;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getChannel() {
        final @Nullable String channel = this.channel;
        return channel != null ? channel : "";
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelType() {
        final @Nullable String ct = channelType;
        if (ct == null || ct.isEmpty()) {
            return BINDING_ID + ":" + getChannel();
        } else {
            return (ct.startsWith("system") ? ct : BINDING_ID + ":" + ct);
        }
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getType() {
        final @Nullable String type = this.type;
        return type != null ? type : "";
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRefresh() {
        final @Nullable Boolean rf = refresh;
        return rf != null && rf.booleanValue() && !getProperty().isEmpty();
    }

    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }

    public String getChannelGroup() {
        final @Nullable String channelGroup = this.channelGroup;
        return channelGroup != null ? channelGroup : "";
    }

    public void setChannelGroup(String channelGroup) {
        this.channelGroup = channelGroup;
    }

    public List<MiIoDeviceAction> getActions() {
        final @Nullable List<MiIoDeviceAction> miIoDeviceActions = this.miIoDeviceActions;
        return (miIoDeviceActions != null) ? miIoDeviceActions : Collections.emptyList();
    }

    public void setActions(List<MiIoDeviceAction> miIoDeviceActions) {
        this.miIoDeviceActions = miIoDeviceActions;
    }

    public @Nullable String getTransfortmation() {
        return transfortmation;
    }

    public void setTransfortmation(String transfortmation) {
        this.transfortmation = transfortmation;
    }

    @Override
    public String toString() {
        return "[ Channel = " + getChannel() + ", friendlyName = " + getFriendlyName() + ", type = " + getType()
                + ", channelType = " + getChannelType() + ", ChannelGroup = " + getChannelGroup() + ", channel = "
                + getChannel() + ", property = " + getProperty() + ", refresh = " + getRefresh() + "]";
    }
}
