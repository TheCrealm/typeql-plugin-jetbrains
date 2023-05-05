package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiOwnsTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
    val ownsTypeTextRange: TextRange
        get() = TextRange(4, 4 + ownsType!!.length)
    val ownsType: String?
        get() = firstChild.nextSibling.nextSibling.lastChild.lastChild.text

    val isAbstractType: Boolean
        get() = ownsType == "abstract"

    val hasAnnotation: Boolean
        get() = children.any { psiElement -> psiElement.node.elementType.toString() == "annotation_owns" }

    override fun getReference(): PsiReference? {
        return if (ownsType == null || isAbstractType) {
            null
        } else ReferenceProvidersRegistry.getReferencesFromProviders(this)[0]
    }
}