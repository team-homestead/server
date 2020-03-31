SELECT a
FROM Agency AS a
         JOIN a.resources AS s
WHERE s IN (?1)
GROUP BY a
HAVING COUNT(s) >= (SELECT COUNT(s2) FROM Service AS s2 WHERE s2 IN (?1));