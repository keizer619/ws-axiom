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
package org.apache.axiom.ts.om.document;

import static com.google.common.truth.Truth.assertThat;

import java.io.StringReader;
import java.util.Iterator;

import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.ts.AxiomTestCase;

/**
 * Tests the behavior of {@link OMDocument#setOMDocumentElement(OMElement)} if the argument is
 * already the document element.
 */
public class TestSetOMDocumentElementReplaceSame extends AxiomTestCase {
    public TestSetOMDocumentElementReplaceSame(OMMetaFactory metaFactory) {
        super(metaFactory);
    }

    protected void runTest() throws Throwable {
        OMFactory factory = metaFactory.getOMFactory();
        OMDocument document = factory.createOMDocument();
        OMElement root = factory.createOMElement("root", null, document);
        document.setOMDocumentElement(root);
        assertThat(document.getOMDocumentElement()).isSameAs(root);
        assertThat(root.getPreviousOMSibling()).isNull();
        assertThat(root.getNextOMSibling()).isNull();
        assertThat(root.getParent()).isSameAs(document);
    }
}