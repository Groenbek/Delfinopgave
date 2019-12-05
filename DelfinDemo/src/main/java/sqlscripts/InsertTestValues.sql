-- insert members
INSERT INTO dolphinclub.members
VALUES (m_id, 'Leopold Kræsten', 45, 'aktiv', 'ja');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Liselotte Smilemåls', 19, 'passiv', 'ja');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Prinsesse Alabama', 12, 'aktiv', 'nej');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Joachim von And', 65, 'aktiv', 'ja');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Egon Olsen', 78, 'passiv', 'nej');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Lars Løkke Rasmussen', 34, 'aktiv', 'ja');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Pernille Landgangsbrød', 8, 'aktiv', 'ja');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Mia Momsemor', 17, 'passiv', 'nej');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Barack O''Drama', 55, 'aktiv', 'ja');
INSERT INTO dolphinclub.members
VALUES (m_id, 'Tonald Drump', 75, 'passiv', 'nej');
-- insert memberstoteam
INSERT INTO dolphinclub.memberstoteam
VALUES (1, 3, 2, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (1, 7, 2, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (1, 8, 1, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 1, 4, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 2, 1, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 4, 3, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 5, 1, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 6, 4, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 9, 4, 'Betalt');
INSERT INTO dolphinclub.memberstoteam
VALUES (2, 10, 1, 'Betalt');
-- insert memberstotraining
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (1, 3, 1, 1309, 45);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (1, 3, 2, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (1, 3, 3, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (1, 3, 4, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (1, 7, 1, 1902, 34);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (1, 7, 2, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (1, 7, 3, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (1, 7, 4, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 1, 1, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (2, 1, 2, 1208, 12);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 1, 3, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (2, 1, 4, 1212, 59);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 4, 1, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 4, 2, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (2, 4, 3, 1202, 230);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 4, 4, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 6, 1, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (2, 6, 2, 2412, 10);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (2, 6, 3, 1212, 1);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 6, 4, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 9, 1, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 9, 2, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, tid)
VALUES (2, 9, 3, 0);
INSERT INTO dolphinclub.memberstotraining (t_id, m_id, d_id, trainingdate, tid)
VALUES (2, 9, 4, 1205, 83);
-- insert memberstoevent and create swimevent
INSERT INTO dolphinclub.swimevent
VALUES (1, 1301, 'Stenbrostævnet');
INSERT INTO dolphinclub.memberstoevent
VALUES (1, 1, 4, 0);
INSERT INTO dolphinclub.memberstoevent
VALUES (1, 6, 2, 0);
INSERT INTO dolphinclub.memberstoevent
VALUES (1, 7, 1, 1);


-- TODO --
-- væk Michael og Sebastian 
-- få sebastian bentley til at lave en readme
-- skriv det her script
-- design designclasse uml
-- saml dokument med modeller + indledning & beskrivelse
-- tests til vi brækker os
-- 