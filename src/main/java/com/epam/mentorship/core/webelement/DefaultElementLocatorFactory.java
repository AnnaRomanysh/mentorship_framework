// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.epam.mentorship.core.webelement;

import com.epam.mentorship.core.driver.DriverProvider;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public final class DefaultElementLocatorFactory implements ElementLocatorFactory {
  private final DriverProvider provider;

  public DefaultElementLocatorFactory(DriverProvider provider) {
    this.provider = provider;
  }

  public ElementLocator createLocator(Field field) {
    return new DefaultElementLocator(provider, field);
  }
}