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
package org.apache.axiom.ts.dom.documentfragment;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axiom.ts.dom.DOMTestCase;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

/** Tests {@link Node#cloneNode(boolean)} with <code>deep</code> set to <code>true</code>. */
public class TestCloneNodeDeep extends DOMTestCase {
    public TestCloneNodeDeep(DocumentBuilderFactory dbf) {
        super(dbf);
    }

    @Override
    protected void runTest() throws Throwable {
        Document document = dbf.newDocumentBuilder().newDocument();
        DocumentFragment fragment = document.createDocumentFragment();
        fragment.appendChild(document.createComment("comment"));
        fragment.appendChild(document.createElementNS(null, "test"));
        DocumentFragment clone = (DocumentFragment) fragment.cloneNode(true);
        assertSame(document, clone.getOwnerDocument());
        Node child = clone.getFirstChild();
        assertNotNull(child);
        assertEquals(Node.COMMENT_NODE, child.getNodeType());
        child = child.getNextSibling();
        assertNotNull(child);
        assertEquals(Node.ELEMENT_NODE, child.getNodeType());
        assertEquals("test", child.getLocalName());
        child = child.getNextSibling();
        assertNull(child);
    }
}
