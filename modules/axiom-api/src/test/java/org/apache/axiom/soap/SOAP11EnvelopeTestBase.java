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
package org.apache.axiom.soap;

import org.apache.axiom.om.OMMetaFactory;

public class SOAP11EnvelopeTestBase extends SOAPEnvelopeTestBase {
    public SOAP11EnvelopeTestBase(OMMetaFactory omMetaFactory) {
        super(omMetaFactory, SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    }
    
    /**
     * Test that adding an arbitrary element to the envelope is allowed. SOAP 1.1 indeed allows for
     * arbitrary elements to appear after the SOAP body.
     */
    public void testAddElementAfterBody() {
        SOAPEnvelope env = soapFactory.getDefaultEnvelope();
        env.addChild(soapFactory.createOMElement("test", "urn:test", "p"));
    }
}