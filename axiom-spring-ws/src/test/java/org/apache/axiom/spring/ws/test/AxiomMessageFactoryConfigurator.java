/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.axiom.spring.ws.test;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.env.MockPropertySource;

public final class AxiomMessageFactoryConfigurator extends MessageFactoryConfigurator {
    private final String feature;

    public AxiomMessageFactoryConfigurator(String feature) {
        super("axiom-" + feature);
        this.feature = feature;
    }

    @Override
    public void configure(GenericApplicationContext context) {
        MockPropertySource propertySource = new MockPropertySource("axiom-properties");
        propertySource.setProperty("axiom.feature", feature);
        context.getEnvironment().getPropertySources().addLast(propertySource);
        new XmlBeanDefinitionReader(context).loadBeanDefinitions(new ClassPathResource(
                "axiom-message-factory.xml", AxiomMessageFactoryConfigurator.class));
    }
}