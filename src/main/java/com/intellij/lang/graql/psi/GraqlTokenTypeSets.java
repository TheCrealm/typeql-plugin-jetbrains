package com.intellij.lang.graql.psi;

import com.intellij.lang.graql.GraqlLanguage;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author github.com/BFergerson
 */
public interface GraqlTokenTypeSets extends GraqlTokenTypes {

    IFileElementType GRAQL_FILE = new IFileElementType("GRAQLFILE", GraqlLanguage.INSTANCE);

    TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    TokenSet COMMENTS = TokenSet.create(SINGLE_LINE_COMMENT);
    TokenSet DATATYPES = TokenSet.create(DOUBLE_KEYWORD, LONG_KEYWORD, STRING_KEYWORD, DATE_KEYWORD, BOOLEAN_KEYWORD);
    TokenSet MODEL = TokenSet.create(ENTITY_KEYWORD, RELATIONSHIP_KEYWORD, ROLE_KEYWORD, ATTRIBUTE_KEYWORD);
    TokenSet KEYWORDS = TokenSet.create(DEFINE_KEYWORD, INSERT_KEYWORD, MATCH_KEYWORD, SUB_KEYWORD, RELATES_KEYWORD,
            KEY_KEYWORD, HAS_KEYWORD, PLAYS_KEYWORD, DATATYPE_KEYWORD, ISA_KEYWORD, COMMIT_KEYWORD, GET_KEYWORD,
            RULE_KEYWORD, WHEN_KEYWORD, THEN_KEYWORD, COMPUTE_KEYWORD, CLUSTER_KEYWORD, IN_KEYWORD, MEMBER_KEYWORD,
            IS_ABSTRACT_KEYWORD, AS_KEYWORD, DELETE_KEYWORD, ASK_KEYWORD, COUNT_KEYWORD, SUM_KEYWORD, MAX_KEYWORD,
            MIN_KEYWORD, MEAN_KEYWORD, MEDIAN_KEYWORD, GROUP_KEYWORD, OF_KEYWORD, STD_KEYWORD, OR_KEYWORD, VAL_KEYWORD,
            CONTAINS_KEYWORD, OFFSET_KEYWORD, LIMIT_KEYWORD, ORDER_KEYWORD, ASC_KEYWORD, DESC_KEYWORD, TRUE_KEYWORD,
            FALSE_KEYWORD, BY_KEYWORD, AGGREGATE_KEYWORD, IF_KEYWORD, DO_KEYWORD, NOT_KEYWORD, ELSE_KEYWORD,
            ELSEIF_KEYWORD, NULL_KEYWORD, FOR_KEYWORD);

    Set<String> FULL_KEYWORD_SET = new HashSet<>(Stream.concat(Stream.concat(Arrays.stream(DATATYPES.getTypes()),
            Arrays.stream(MODEL.getTypes())), Arrays.stream(KEYWORDS.getTypes()))
            .map(IElementType::toString).collect(Collectors.toList()));

}