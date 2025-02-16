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
package org.apache.axiom.ts.dom.element;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axiom.ts.dom.DOMTestCase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class TestAppendChild extends DOMTestCase {
    public TestAppendChild(DocumentBuilderFactory dbf) {
        super(dbf);
    }

    @Override
    protected void runTest() throws Throwable {
        String elementName = "TestElem";
        String childElemName = "TestChildElem";
        String childTextValue = "text value of the child text node";

        // Apending am Element node
        Document doc = dbf.newDocumentBuilder().newDocument();
        Element elem = doc.createElement(elementName);
        Element childElem = doc.createElement(childElemName);

        elem.appendChild(childElem);

        Element addedChild = (Element) elem.getFirstChild();
        assertNotNull("Child Element node missing", addedChild);
        assertEquals("Incorre node object", childElem, addedChild);

        elem = doc.createElement(elementName);
        Text text = doc.createTextNode(childTextValue);
        elem.appendChild(text);

        Text addedTextnode = (Text) elem.getFirstChild();
        assertNotNull("Child Text node missing", addedTextnode);
        assertEquals("Incorrect node object", text, addedTextnode);
    }
}
