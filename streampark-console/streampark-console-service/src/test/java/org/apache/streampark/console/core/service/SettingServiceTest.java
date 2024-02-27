/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.streampark.console.core.service;

import org.apache.streampark.console.SpringTestBase;
import org.apache.streampark.console.core.bean.SettingAlertEmailConfigParams;
import org.apache.streampark.console.core.bean.SettingDockerConfigParams;
import org.apache.streampark.console.core.entity.Setting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

class SettingServiceTest extends SpringTestBase {
  private final SettingDockerConfigParams dockerConfigParams = new SettingDockerConfigParams();
  private final SettingAlertEmailConfigParams alertEmailConfigParams =
      new SettingAlertEmailConfigParams();

  @Autowired SettingService settingService;

  /*docker config*/
  void initDockerConfigParams(SettingDockerConfigParams params) {
    Setting address = settingService.get("docker.register.address");
    address.setSettingValue("test-address-setting-value");
    Setting username = settingService.get("docker.register.user");
    username.setSettingValue("test-username-setting-value");
    Setting password = settingService.get("docker.register.password");
    password.setSettingValue("test-password-setting-value");
    Setting namespace = settingService.get("docker.register.namespace");
    namespace.setSettingValue("test-namespace-setting-value");
    params.setAddress(address);
    params.setUsername(username);
    params.setPassword(password);
    params.setNamespace(namespace);
  }

  @Test
  void testUpdateDockerConfigTest() {
    initDockerConfigParams(dockerConfigParams);
    List<Setting> settings =
        Arrays.asList(
            dockerConfigParams.getAddress(),
            dockerConfigParams.getNamespace(),
            dockerConfigParams.getUsername(),
            dockerConfigParams.getPassword());
    settingService.updateSettings(settings);

    Assertions.assertEquals(
        "test-address-setting-value",
        settingService.get("docker.register.address").getSettingValue());
    Assertions.assertEquals(
        "test-username-setting-value",
        settingService.get("docker.register.user").getSettingValue());
    Assertions.assertEquals(
        "test-password-setting-value",
        settingService.get("docker.register.password").getSettingValue());
    Assertions.assertEquals(
        "test-namespace-setting-value",
        settingService.get("docker.register.namespace").getSettingValue());
  }

  /*alert email config*/
  void initAlertEmailConfigParams(SettingAlertEmailConfigParams params) {
    Setting host = settingService.get("alert.email.host");
    host.setSettingValue("test-host-setting-value");
    Setting port = settingService.get("alert.email.port");
    port.setSettingValue("test-port-setting-value");
    Setting from = settingService.get("alert.email.from");
    from.setSettingValue("test-from-setting-value");
    Setting username = settingService.get("alert.email.userName");
    username.setSettingValue("test-username-setting-value");
    Setting password = settingService.get("alert.email.password");
    password.setSettingValue("test-password-setting-value");
    Setting ssl = settingService.get("alert.email.ssl");
    ssl.setSettingValue("test-ssl-setting-value");
    params.setHost(host);
    params.setPort(port);
    params.setFrom(from);
    params.setUsername(username);
    params.setPassword(password);
    params.setSsl(ssl);
  }

  @Test
  void testUpdateAlertEmailConfigTest() {
    initAlertEmailConfigParams(alertEmailConfigParams);
    List<Setting> settings =
        Arrays.asList(
            alertEmailConfigParams.getHost(),
            alertEmailConfigParams.getPort(),
            alertEmailConfigParams.getFrom(),
            alertEmailConfigParams.getUsername(),
            alertEmailConfigParams.getPassword(),
            alertEmailConfigParams.getSsl());
    settingService.updateSettings(settings);

    Assertions.assertEquals(
        "test-host-setting-value", settingService.get("alert.email.host").getSettingValue());
    Assertions.assertEquals(
        "test-port-setting-value", settingService.get("alert.email.port").getSettingValue());
    Assertions.assertEquals(
        "test-from-setting-value", settingService.get("alert.email.from").getSettingValue());
    Assertions.assertEquals(
        "test-username-setting-value",
        settingService.get("alert.email.userName").getSettingValue());
    Assertions.assertEquals(
        "test-password-setting-value",
        settingService.get("alert.email.password").getSettingValue());
    Assertions.assertEquals(
        "test-ssl-setting-value", settingService.get("alert.email.ssl").getSettingValue());
  }
}